package uk.ac.mmu.game.applicationcode.domain.rules.Outcomes;

import uk.ac.mmu.game.domain.entities.MoveResult;
import Game.States.GameStateInPlay;
import uk.ac.mmu.game.domain.rules.Outcomes.MoveOutcome;

public class OverShootOutcome extends MoveOutcome {

    public OverShootOutcome() {
        this.endsTurn = true;
    }

    @Override
    public void apply(GameStateInPlay ctx, MoveResult result) {
        ctx.onOvershoot(result.player);
    }
}
