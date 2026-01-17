package uk.ac.mmu.game.applicationcode.domain.rules.Outcomes;

import uk.ac.mmu.game.applicationcode.domain.entities.MoveResult;
import uk.ac.mmu.game.applicationcode.domain.state.GameStateInPlay;

public class NormalOutcome extends MoveOutcome {

  @Override
  public void apply(GameStateInPlay ctx, MoveResult result) {
    ctx.onMove(result);
  }
}
