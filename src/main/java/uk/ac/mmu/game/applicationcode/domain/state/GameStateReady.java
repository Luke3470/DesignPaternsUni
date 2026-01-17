package uk.ac.mmu.game.applicationcode.domain.state;


import uk.ac.mmu.game.applicationcode.domain.Game;


public class GameStateReady implements GameState {

  private final Game game;

  public GameStateReady(Game game) {
    this.game = game;
  }

  @Override
  public void play() {
    this.next();
  }

  @Override
  public void next() {
    game.getMediator().notifyStateChange("Ready", "Inplay");
    game.setState(new GameStateInPlay(game));
  }

  @Override
  public String toString() {
    return "Game State: Game Ready";
  }

  @Override
  public void show() {
    game.getMediator().notifyViewState("Game State: Game Ready");
  }
}
