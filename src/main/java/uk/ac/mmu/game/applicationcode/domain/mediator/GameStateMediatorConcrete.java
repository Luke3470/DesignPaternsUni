package uk.ac.mmu.game.applicationcode.domain.mediator;

import uk.ac.mmu.game.applicationcode.domain.Game;
import uk.ac.mmu.game.applicationcode.domain.observers.StateObserver;
import uk.ac.mmu.game.infrastructure.driven.console.payload.StateChange;
import uk.ac.mmu.game.infrastructure.driven.console.payload.ViewState;

public class GameStateMediatorConcrete implements GameStateMediator {

  private final Game game;

  public GameStateMediatorConcrete(Game game) {
    this.game = game;
  }

  @Override
  public void notifyStateChange(String currentState, String nextState) {
    StateChange event = new StateChange(currentState, nextState);
    game.notifyObservers(StateObserver.class, obs -> obs.onEvent(event));
  }

  @Override
  public void notifyViewState(String state) {
    ViewState event = new ViewState(state);
    game.notifyObservers(StateObserver.class, obs -> obs.onEvent(event));
  }
}
