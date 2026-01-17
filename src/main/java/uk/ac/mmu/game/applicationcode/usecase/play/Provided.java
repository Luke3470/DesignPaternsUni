package uk.ac.mmu.game.applicationcode.usecase.play;

import uk.ac.mmu.game.applicationcode.usecase.RequiredAssetFactory;
import uk.ac.mmu.game.applicationcode.usecase.RequiredDice;
import uk.ac.mmu.game.applicationcode.usecase.RequiredHitCondition;
import uk.ac.mmu.game.applicationcode.usecase.RequiredWinCondition;

public interface Provided {
    void play();

    static Provided getInstance(RequiredDice dice,
                                RequiredAssetFactory assets,
                                RequiredHitCondition hitCondition,
                                RequiredWinCondition winCondition) {
        return new PlayGameUseCase(dice, assets, hitCondition, winCondition);
    }
}
