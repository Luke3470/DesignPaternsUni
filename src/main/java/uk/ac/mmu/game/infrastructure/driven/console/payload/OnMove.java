package uk.ac.mmu.game.infrastructure.driven.console.payload;

import uk.ac.mmu.game.applicationcode.domain.entities.MoveResult;

public class OnMove {

  final public MoveResult result;

  public OnMove(MoveResult result) {
    this.result = result;
  }
}
