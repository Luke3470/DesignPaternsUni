package uk.ac.mmu.game.applicationcode.domain.state;

import uk.ac.mmu.game.applicationcode.domain.Game;
import uk.ac.mmu.game.applicationcode.domain.dice.NonRandomDice;
import uk.ac.mmu.game.applicationcode.domain.observers.FileObserver;
import uk.ac.mmu.game.infrastructure.driven.file.payload.*;

public class GameStateGameOver implements GameState {
    private Game game;

    GameStateGameOver(Game game){
        this.game = game;
    }
    @Override
    public void play(){;
        if (game.getDice() instanceof NonRandomDice){
            int len = ((NonRandomDice) game.getDice()).length();
            for (int i = 0; i < len-game.getRolls().size(); i++) {
                next();
            }
        }
        CreateFile file = game.save();
        game.notifyObservers(FileObserver.class, FileObserver -> FileObserver.onEvent(file));

    }

    @Override
    public void next(){
        game.getMediator().notifyStateChange("Game Over", null);
    }

    @Override
    public void show() {
        game.getMediator().notifyViewState("Game Over");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public String toString(){
        return "Game State: Game Over";
    }
}
