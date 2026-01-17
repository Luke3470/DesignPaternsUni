package uk.ac.mmu.game.infrastructure.console.payload;

import uk.ac.mmu.game.domain.entities.MoveResult;


public class OnMove {
    public MoveResult result;

    public OnMove(MoveResult result) {
        this.result = result;
    }
}
