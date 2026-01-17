package uk.ac.mmu.game.applicationcode.domain.rules.Outcomes;


import uk.ac.mmu.game.applicationcode.domain.entities.MoveResult;
import uk.ac.mmu.game.applicationcode.domain.state.GameStateInPlay;

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
