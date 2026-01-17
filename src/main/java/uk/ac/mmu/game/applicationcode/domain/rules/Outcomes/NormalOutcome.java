package uk.ac.mmu.game.applicationcode.domain.rules.Outcomes;

import uk.ac.mmu.game.domain.entities.MoveResult;
import Game.States.GameStateInPlay;
import uk.ac.mmu.game.domain.rules.Outcomes.MoveOutcome;

public class NormalOutcome extends MoveOutcome {

    @Override
    public void apply(GameStateInPlay ctx, MoveResult result) {
        ctx.onMove(result);
    }
}
