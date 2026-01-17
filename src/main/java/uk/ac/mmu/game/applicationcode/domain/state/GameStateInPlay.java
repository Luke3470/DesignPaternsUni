package uk.ac.mmu.game.applicationcode.domain.state;


import java.util.Stack;
import uk.ac.mmu.game.applicationcode.domain.Game;
import uk.ac.mmu.game.applicationcode.domain.board.Board;
import uk.ac.mmu.game.applicationcode.domain.dice.Dice;
import uk.ac.mmu.game.applicationcode.domain.dice.Types.RollValue;
import uk.ac.mmu.game.applicationcode.domain.entities.Command;
import uk.ac.mmu.game.applicationcode.domain.entities.MoveCommand;
import uk.ac.mmu.game.applicationcode.domain.entities.MoveResult;
import uk.ac.mmu.game.applicationcode.domain.entities.Player;
import uk.ac.mmu.game.applicationcode.domain.mediator.GameStateMediator;
import uk.ac.mmu.game.applicationcode.domain.observers.PlayObserver;
import uk.ac.mmu.game.applicationcode.domain.rules.HitCondition;
import uk.ac.mmu.game.applicationcode.domain.rules.Outcomes.MoveOutcome;
import uk.ac.mmu.game.applicationcode.domain.rules.WinCondition;
import uk.ac.mmu.game.infrastructure.driven.console.payload.OnHit;
import uk.ac.mmu.game.infrastructure.driven.console.payload.OnMove;
import uk.ac.mmu.game.infrastructure.driven.console.payload.OnOverShoot;
import uk.ac.mmu.game.infrastructure.driven.console.payload.OnRemain;
import uk.ac.mmu.game.infrastructure.driven.console.payload.OnRoll;
import uk.ac.mmu.game.infrastructure.driven.console.payload.OnWin;

public class GameStateInPlay implements GameState {

  public Game game = null;
  protected HitCondition hitCondition = null;
  protected WinCondition winCondition = null;
  public Stack<Command> history = null;
  public int turn = 0;
  public int totalTurns = 0;
  public GameStateMediator mediator;

  GameStateInPlay(Game game) {
    this.game = game;
    this.hitCondition = game.getHitCondition();
    this.winCondition = game.getWinCondition();
    this.history = new Stack<>();
    this.mediator = game.getMediator();
  }

  @Override
  public void play() {
    Dice die = game.getDice();
    Board board = game.getBoard();

    for (Player player : game.getPlayersList()) {
      incrementTurn(player);

      MoveResult result = rollAndMove(player, die, board);

      MoveOutcome hitOutcome = hitCondition.checkHit(board, result);
        if (applyOutcome(hitOutcome, result)) {
            continue;
        }

      MoveOutcome winOutcome = winCondition.checkWin(board, result);
      applyOutcome(winOutcome, result);

        if (winOutcome != null && winOutcome.endsGame()) {
            this.next();
        }
    }

  }

  @Override
  public void next() {
    mediator.notifyStateChange("In Play", "Game Over");
    game.setState(new GameStateGameOver(game));
  }

  @Override
  public String toString() {
    return "Game State: In Play";
  }

  @Override
  public void show() {
    mediator.notifyViewState("In Play");
  }

  public void onMove(MoveResult result) {
    OnMove event = new OnMove(result);
    game.notifyObservers(PlayObserver.class, PlayObserver -> PlayObserver.onEvent(event));
  }

  public void onWin(Player player, int turn, int totalTurns) {
    OnWin event = new OnWin(player, turn, totalTurns);
    game.notifyObservers(PlayObserver.class, PlayObserver -> PlayObserver.onEvent(event));
  }

  public void onHit(MoveResult result, String playerHit) {
    OnHit event = new OnHit(result.player.getTextColour(), playerHit, result.to);
    game.notifyObservers(PlayObserver.class, PlayObserver -> PlayObserver.onEvent(event));
  }

  public void onOvershoot(Player player) {
    OnOverShoot event = new OnOverShoot(player.getTextColour(), player.getName());
    game.notifyObservers(PlayObserver.class, PlayObserver -> PlayObserver.onEvent(event));
  }

  public void onRemain(Player player, MoveResult result) {
    OnRemain event = new OnRemain(player.getName(), result.from);
    game.notifyObservers(PlayObserver.class, PlayObserver -> PlayObserver.onEvent(event));
  }

  private void incrementTurn(Player player) {
    totalTurns++;
      if (player.getIndex() == 0) {
          turn++;
      }
  }

  private void updateRoll(Player player, int roll) {
    OnRoll event = new OnRoll(player, roll, this.turn);
    game.notifyObservers(PlayObserver.class, PlayObserver -> PlayObserver.onEvent(event));
  }

  private MoveResult rollAndMove(Player player, Dice die, Board board) {
    int roll = die.roll();
    game.addRoll(RollValue.of(roll));
    updateRoll(player, roll);
    Command move = new MoveCommand(player, board, roll);
    MoveResult result = move.execute();
    history.push(move);

    return result;
  }

  private boolean applyOutcome(MoveOutcome outcome, MoveResult result) {
      if (outcome == null) {
          return false;
      }

    outcome.apply(this, result);
    return outcome.endsTurn() || outcome.endsGame();
  }

}
