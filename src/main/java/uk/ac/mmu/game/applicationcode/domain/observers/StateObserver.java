package uk.ac.mmu.game.applicationcode.domain.observers;


import uk.ac.mmu.game.infrastructure.driven.console.payload.*;

public interface StateObserver extends BaseObserver {
    void onEvent(StateChange payload);
    void onEvent(ViewState payload);
    void onEvent(EndState payload);
}
