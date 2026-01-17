package uk.ac.mmu.game.applicationcode.domain.observers;

import Game.Assets.Payloads.*;

public interface PlayObserver extends BaseObserver {
    void onEvent(OnRoll roll);
    void onEvent(OnMove move);
    void onEvent(OnHit hit);
    void onEvent(OnWin win);
    void onEvent(OnOverShoot overshoot);
    void onEvent(Initialization init);
}
