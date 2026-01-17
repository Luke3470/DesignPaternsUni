package uk.ac.mmu.game.applicationcode.usecase;

import uk.ac.mmu.game.applicationcode.domain.rules.WinCondition;
import uk.ac.mmu.game.applicationcode.usecase.play.PlayGameUseCase;

public interface RequiredWinCondition {
    WinCondition getWinCondition();
}