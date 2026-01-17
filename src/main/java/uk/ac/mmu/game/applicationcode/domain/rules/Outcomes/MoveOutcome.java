package uk.ac.mmu.game.applicationcode.domain.rules.Outcomes;

import uk.ac.mmu.game.domain.entities.MoveResult;
import Game.States.GameStateInPlay;

public abstract class MoveOutcome {
    protected boolean endsTurn = false;
    protected boolean endsGame = false;

    public boolean endsTurn() {
        return endsTurn;
    }

    public boolean endsGame() {
        return endsGame;
    }
    public abstract void apply(GameStateInPlay ctx, MoveResult result);
}
