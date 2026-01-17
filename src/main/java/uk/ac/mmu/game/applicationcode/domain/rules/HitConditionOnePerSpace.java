package uk.ac.mmu.game.applicationcode.domain.rules;

import uk.ac.mmu.game.domain.entities.MoveResult;
import uk.ac.mmu.game.domain.entities.Player;
import uk.ac.mmu.game.domain.rules.HitCondition;
import uk.ac.mmu.game.domain.rules.Outcomes.HitUndoOutcome;
import uk.ac.mmu.game.domain.rules.Outcomes.MoveOutcome;

public class HitConditionOnePerSpace implements HitCondition {
    @Override
    public MoveOutcome checkHit(Board board, MoveResult move) {
        Player player = move.player;
        String pos = move.to;

        String occupantsStr = board.posContains(pos,move.player);

        if (occupantsStr == null || occupantsStr.isEmpty()) {
            return null;
        }


        if (occupantsStr.equals(player.getName())) {
            return null;
        }


        return new HitUndoOutcome(occupantsStr);
    }
    @Override
    public String toString(){
        return "HitConditionOnePerSpace";
    }
}
