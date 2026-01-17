package uk.ac.mmu.game.applicationcode.domain.rules.Outcomes;

import uk.ac.mmu.game.domain.entities.MoveResult;
import Game.States.GameStateInPlay;
import uk.ac.mmu.game.domain.rules.Outcomes.MoveOutcome;

public class OvershootWinOutcome extends MoveOutcome {

    public OvershootWinOutcome() {
        this.endsGame = true;
    }
    @Override
    public void apply(GameStateInPlay ctx, MoveResult result) {
        ctx.onOvershoot(result.player);
        ctx.onWin(result.player, ctx.turn, ctx.totalTurns);
    }
}