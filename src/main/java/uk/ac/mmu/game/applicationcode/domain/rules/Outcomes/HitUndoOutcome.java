package uk.ac.mmu.game.applicationcode.domain.rules.Outcomes;

import uk.ac.mmu.game.applicationcode.domain.entities.MoveResult;
import uk.ac.mmu.game.applicationcode.domain.state.GameStateInPlay;

public class HitUndoOutcome extends MoveOutcome {
    private String playerHit;

    public HitUndoOutcome(String playerHit) {
        this.endsTurn = true;
        this.playerHit = playerHit;
    }
    @Override
    public void apply(GameStateInPlay ctx, MoveResult result) {
        ctx.history.pop().undo();
        ctx.onHit(result,playerHit);
    }
}
