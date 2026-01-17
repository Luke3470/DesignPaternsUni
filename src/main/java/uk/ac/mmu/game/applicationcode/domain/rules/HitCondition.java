package uk.ac.mmu.game.applicationcode.domain.rules;

import uk.ac.mmu.game.domain.entities.MoveResult;
import uk.ac.mmu.game.domain.rules.Outcomes.MoveOutcome;

public interface HitCondition {
    MoveOutcome checkHit(Board board, MoveResult move);
}
