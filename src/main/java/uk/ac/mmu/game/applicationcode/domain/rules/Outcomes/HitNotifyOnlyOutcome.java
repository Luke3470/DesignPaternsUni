package uk.ac.mmu.game.applicationcode.domain.rules.Outcomes;

import uk.ac.mmu.game.domain.entities.MoveResult;
import Game.States.GameStateInPlay;
import uk.ac.mmu.game.domain.rules.Outcomes.MoveOutcome;

public class HitNotifyOnlyOutcome extends MoveOutcome {
    private String playerHit;

    public HitNotifyOnlyOutcome(String playerHit) {
        this.playerHit = playerHit;
    }

    @Override
    public void apply(GameStateInPlay ctx, MoveResult result) {
        ctx.onHit(result, this.playerHit);
    }
}
