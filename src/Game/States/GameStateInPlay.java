package Game.States;

import Game.BaseGame;

public class GameStateInPlay implements GameState{
    @Override
    public void printStatus(){
        System.out.println("In Play");
    }
    @Override
    public void prev(BaseGame game){
        System.out.println("Game Moving From In Play -> Game Over");
        game.setState(new GameStateReady());
    }
    @Override
    public void next(BaseGame game){
        System.out.println("Game Moving From In Play -> Ready");
        game.setState(new GameStateGameOver());
    }
}
