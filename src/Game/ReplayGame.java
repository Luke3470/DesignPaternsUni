package Game;

import Game.States.GameState;
import Game.States.GameStateReady;

class ReplayGame implements BaseGame{

    private GameState state = new GameStateReady();

    public void previousState() {state.prev(this);}

    public void nextState() {
        state.next(this);
    }

    public void printStatus(){
        state.printStatus();
    }

    public GameState getState() {
        return state;
    }

    @Override
    public void setState(GameState state){
        this.state = state;
    }

}
