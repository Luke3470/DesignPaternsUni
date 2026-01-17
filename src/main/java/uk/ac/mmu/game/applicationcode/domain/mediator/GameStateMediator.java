package uk.ac.mmu.game.applicationcode.domain.mediator;

public interface GameStateMediator {

  void notifyStateChange(String currentState, String nextState);

  void notifyViewState(String state);
}
