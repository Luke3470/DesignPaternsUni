package uk.ac.mmu.game.infrastructure.driven.console.payload;

public class StateChange {

  final public String currentState;
  final public String newState;

  public StateChange(String currentState, String newState) {
    this.currentState = currentState;
    this.newState = newState;
  }
}
