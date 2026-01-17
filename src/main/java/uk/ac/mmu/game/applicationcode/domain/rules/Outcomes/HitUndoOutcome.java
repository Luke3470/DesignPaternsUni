package uk.ac.mmu.game.applicationcode.domain.rules.Outcomes;

import uk.ac.mmu.game.domain.entities.MoveResult;
import Game.States.GameStateInPlay;
import uk.ac.mmu.game.domain.rules.Outcomes.MoveOutcome;

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
