package uk.ac.mmu.game.applicationcode.domain.state;

public interface GameState {
    void play();
    void next();
    void updateState(String currentState, String nextState);
    void displayState(String state);
    void show();
}
