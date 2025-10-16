package Game.States;

import Game.BaseGame;

public interface GameState {
    void next(BaseGame game);
    void prev(BaseGame game);
    void printStatus();
}
