package Game.States;

import Game.BaseGame;

public class GameStateGameOver implements GameState{
    @Override
    public void printStatus(){
        System.out.println("Game Over");
    }
    @Override
    public void prev(BaseGame game){
        System.out.println("Game Is Moving From Game Over -> In Play");
        game.setState(new GameStateInPlay());
    }
    @Override
    public void next(BaseGame game){
        System.out.println("Game Over");
    }
}
