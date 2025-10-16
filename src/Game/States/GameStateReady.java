package Game.States;

import Game.BaseGame;

public class GameStateReady implements GameState{
    @Override
    public void printStatus(){
        System.out.println("Game Ready");
    }
    @Override
    public void prev(BaseGame game){
        System.out.println("Game In Base State");
    }
    @Override
    public void next(BaseGame game){
        System.out.println("Moving From Ready -> In Play");
        game.setState(new GameStateInPlay());
    }
}
