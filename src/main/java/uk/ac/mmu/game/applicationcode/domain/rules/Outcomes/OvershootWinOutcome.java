package uk.ac.mmu.game.applicationcode.domain.rules.Outcomes;


import uk.ac.mmu.game.applicationcode.domain.entities.MoveResult;
import uk.ac.mmu.game.applicationcode.domain.state.GameStateInPlay;

class OvershootWinOutcome extends MoveOutcome {

    public OvershootWinOutcome() {
        this.endsGame = true;
    }
    @Override
    public void apply(GameStateInPlay ctx, MoveResult result) {
        ctx.onOvershoot(result.player);
        ctx.onWin(result.player, ctx.turn, ctx.totalTurns);
    }
}