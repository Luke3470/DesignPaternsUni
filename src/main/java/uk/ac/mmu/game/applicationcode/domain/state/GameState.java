package uk.ac.mmu.game.applicationcode.domain.state;

public interface GameState {
    void play();
    void next();
    void show();
}
