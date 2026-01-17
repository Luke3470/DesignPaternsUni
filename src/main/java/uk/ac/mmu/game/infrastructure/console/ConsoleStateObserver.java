package uk.ac.mmu.game.infrastructure.console;

import uk.ac.mmu.game.infrastructure.console.payload.EndState;
import uk.ac.mmu.game.infrastructure.console.payload.StateChange;
import uk.ac.mmu.game.infrastructure.console.payload.ViewState;

public class ConsoleStateObserver implements StateObserver {

    @Override
    public void onEvent(StateChange payload) {
        System.out.println(payload.currentState+" -> " + payload.newState);
    }

    @Override
    public void onEvent(ViewState payload) {
        System.out.println(payload.state);
    }

    @Override
    public void onEvent(EndState payload) {
        System.out.println(payload.state);
    }
}
