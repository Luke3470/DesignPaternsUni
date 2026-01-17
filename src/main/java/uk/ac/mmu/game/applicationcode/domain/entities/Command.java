package uk.ac.mmu.game.applicationcode.domain.entities;

public interface Command {
    MoveResult execute();
    void undo();
}
