package uk.ac.mmu.game.applicationcode.domain.observers;

import uk.ac.mmu.game.infrastructure.driven.console.payload.*;

public interface PlayObserver extends BaseObserver {
    void onEvent(OnRoll roll);
    void onEvent(OnMove move);
    void onEvent(OnHit hit);
    void onEvent(OnWin win);
    void onEvent(OnOverShoot overshoot);
    void onEvent(Initialization init);
}
