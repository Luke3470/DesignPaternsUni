package uk.ac.mmu.game.applicationcode.domain.state;

import uk.ac.mmu.game.domain.state.GameState;
import uk.ac.mmu.game.infrastructure.file.payload.CreateFile;
import uk.ac.mmu.game.infrastructure.console.payload.EndState;
import uk.ac.mmu.game.infrastructure.console.payload.ViewState;
import uk.ac.mmu.game.application.Game;

public class GameStateGameOver implements GameState {
    private Game game;

    GameStateGameOver(Game game){
        this.game = game;
    }
    @Override
    public void play(){
       CreateFile file = game.save();
       game.notifyObservers(FileObserver.class,FileObserver -> FileObserver.onEvent(file));

    }
    @Override
    public void next(){
        updateState("Game Over",null);
    }

    @Override
    public void updateState(String currentState, String nextState){
        EndState event = new EndState(currentState);
        game.notifyObservers(StateObserver.class, StateObserver -> StateObserver.onEvent(event));
    }

    @Override
    public void displayState(String state) {
        ViewState event = new ViewState(state);
        game.notifyObservers(StateObserver.class, StateObserver -> StateObserver.onEvent(event));
    }

    @Override
    public void show() {
        displayState("Game Over");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o){
        return false;
    }

    @Override
    public String toString(){
        return "Game State: Game Over";
    }
}
