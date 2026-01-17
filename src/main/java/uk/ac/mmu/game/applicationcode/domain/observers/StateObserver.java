package uk.ac.mmu.game.applicationcode.domain.observers;


import uk.ac.mmu.game.infrastructure.driven.console.payload.EndState;
import uk.ac.mmu.game.infrastructure.driven.console.payload.StateChange;
import uk.ac.mmu.game.infrastructure.driven.console.payload.ViewState;

public interface StateObserver extends BaseObserver {

  void onEvent(StateChange payload);

  void onEvent(ViewState payload);

  void onEvent(EndState payload);
}
