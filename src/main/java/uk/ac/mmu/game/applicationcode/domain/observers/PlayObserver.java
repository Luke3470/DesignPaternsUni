package uk.ac.mmu.game.applicationcode.domain.observers;

import uk.ac.mmu.game.infrastructure.driven.console.payload.Initialization;
import uk.ac.mmu.game.infrastructure.driven.console.payload.OnHit;
import uk.ac.mmu.game.infrastructure.driven.console.payload.OnMove;
import uk.ac.mmu.game.infrastructure.driven.console.payload.OnOverShoot;
import uk.ac.mmu.game.infrastructure.driven.console.payload.OnRemain;
import uk.ac.mmu.game.infrastructure.driven.console.payload.OnRoll;
import uk.ac.mmu.game.infrastructure.driven.console.payload.OnWin;

public interface PlayObserver extends BaseObserver {

  void onEvent(OnRoll roll);

  void onEvent(OnMove move);

  void onEvent(OnHit hit);

  void onEvent(OnWin win);

  void onEvent(OnOverShoot overshoot);

  void onEvent(Initialization init);

  void onEvent(OnRemain onRemain);
}
