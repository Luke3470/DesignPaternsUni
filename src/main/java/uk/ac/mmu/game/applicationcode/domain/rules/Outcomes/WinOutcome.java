package uk.ac.mmu.game.applicationcode.domain.rules.Outcomes;


import uk.ac.mmu.game.applicationcode.domain.entities.MoveResult;
import uk.ac.mmu.game.applicationcode.domain.state.GameStateInPlay;

public class WinOutcome extends MoveOutcome {

    public WinOutcome() {
        this.endsGame = true;
    }

    @Override
    public void apply(GameStateInPlay ctx, MoveResult result) {
        ctx.onMove(result);
        ctx.onWin(result.player, ctx.turn, ctx.totalTurns);
    }
}
