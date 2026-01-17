package uk.ac.mmu.game.applicationcode.domain.rules.Outcomes;

import uk.ac.mmu.game.applicationcode.domain.entities.MoveResult;
import uk.ac.mmu.game.applicationcode.domain.state.GameStateInPlay;


public class OverShootOutcome extends MoveOutcome {

    public OverShootOutcome() {
        this.endsTurn = true;
    }

    @Override
    public void apply(GameStateInPlay ctx, MoveResult result) {
        ctx.history.pop().undo();
        ctx.onOvershoot(result.player);
        ctx.onRemain(result.player,result);
    }
}
