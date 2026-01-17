package uk.ac.mmu.game.applicationcode.domain.state;


import uk.ac.mmu.game.applicationcode.domain.Game;
import uk.ac.mmu.game.applicationcode.domain.observers.StateObserver;
import uk.ac.mmu.game.infrastructure.driven.console.payload.*;

public class GameStateReady implements GameState {
    private Game game;

    public GameStateReady(Game game) {
        this.game = game;
    }

    @Override
    public void play() {
        this.next();
    }
    @Override
    public void next(){
        updateState("Ready","Inplay");
        game.setState(new GameStateInPlay(game));
    }
    @Override
    public String toString(){
        return "Game State: Game Ready";
    }
    @Override
    public void updateState(String currentState, String nextState){
        StateChange event = new StateChange(currentState,nextState);
        game.notifyObservers(StateObserver.class, StateObserver -> StateObserver.onEvent(event));
    }

    @Override
    public void displayState(String state) {
        ViewState event = new ViewState(state);
        game.notifyObservers(StateObserver.class, StateObserver -> StateObserver.onEvent(event));
    }

    @Override
    public void show() {
        displayState("Game State: Game Ready");
    }
}
