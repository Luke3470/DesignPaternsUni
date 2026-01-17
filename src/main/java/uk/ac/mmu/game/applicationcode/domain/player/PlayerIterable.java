package uk.ac.mmu.game.applicationcode.domain.player;


import java.util.Iterator;
import org.jspecify.annotations.NonNull;
import uk.ac.mmu.game.applicationcode.domain.Game;
import uk.ac.mmu.game.applicationcode.domain.entities.Player;
import uk.ac.mmu.game.applicationcode.domain.state.GameStateGameOver;

public class PlayerIterable implements Iterable<Player> {

  private final PlayerSelector playerSelector;
  private Game exitCondition = null;

  public PlayerIterable(PlayerSelector playerSelector) {
    this.playerSelector = playerSelector;
  }

  public void setGame(Game game) {
    this.exitCondition = game;
  }

  @Override
  public @NonNull Iterator<Player> iterator() {
    return new PlayerIterator();
  }

  private class PlayerIterator implements Iterator<Player> {

    @Override
    public boolean hasNext() {
      if (exitCondition == null) {
        throw new IllegalStateException("Must Provide Iterator Exit Condition: GameState");
      }
      return !(exitCondition.getState() instanceof GameStateGameOver);
    }

    @Override
    public Player next() {
      return playerSelector.next();
    }
  }
}
