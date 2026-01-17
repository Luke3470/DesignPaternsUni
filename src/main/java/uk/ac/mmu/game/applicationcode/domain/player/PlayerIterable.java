package uk.ac.mmu.game.applicationcode.domain.player;


import Game.States.GameStateGameOver;
import uk.ac.mmu.game.application.Game;
import uk.ac.mmu.game.domain.player.PlayerSelector;

import java.util.Iterator;

public class PlayerIterable implements Iterable<Player> {
    private final PlayerSelector playerSelector;
    private Game exitCondition= null;

    public PlayerIterable(PlayerSelector playerSelector) {
        this.playerSelector = playerSelector;
    }

    public void setGame(Game game){
        this.exitCondition = game;
    }

    @Override
    public Iterator<Player> iterator(){
        return new PlayerIterator();
    }
    private class PlayerIterator implements Iterator<Player> {
        @Override
        public boolean hasNext() {
            if (exitCondition == null){
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
