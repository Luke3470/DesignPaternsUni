package uk.ac.mmu.game.applicationcode.domain.rules.Outcomes;

import uk.ac.mmu.game.domain.entities.MoveResult;
import Game.States.GameStateInPlay;

public class WinOutcome extends MoveOutcome {

    public WinOutcome() {
        this.endsGame = true;
    }

    @Override
    public void apply(GameStateInPlay ctx, MoveResult result) {
        ctx.onWin(result.player, ctx.turn, ctx.totalTurns);
    }
}
