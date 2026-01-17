package uk.ac.mmu.game.applicationcode.domain.rules;


import uk.ac.mmu.game.applicationcode.domain.board.Board;
import uk.ac.mmu.game.applicationcode.domain.entities.MoveResult;
import uk.ac.mmu.game.applicationcode.domain.rules.Outcomes.MoveOutcome;

public interface HitCondition {
    MoveOutcome checkHit(Board board, MoveResult move);
}
