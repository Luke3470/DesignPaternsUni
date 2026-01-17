package uk.ac.mmu.game.applicationcode.usecase.playhistoric;

import uk.ac.mmu.game.applicationcode.domain.Game;
import uk.ac.mmu.game.applicationcode.domain.dice.Dice;
import uk.ac.mmu.game.applicationcode.domain.factories.AssetFactory;
import uk.ac.mmu.game.applicationcode.domain.rules.HitCondition;
import uk.ac.mmu.game.applicationcode.domain.rules.WinCondition;
import uk.ac.mmu.game.applicationcode.usecase.*;

public class PlayHistoricUseCase implements ProvidedPlayHistoric {
    private final Dice dice;
    private final AssetFactory assets;
    private final HitCondition hitCondition;
    private final WinCondition winCondition;

    public PlayHistoricUseCase(RequiredHistoricGame requiredHistoricGame) {
        this.dice = requiredHistoricGame.getDice();
        this.assets = requiredHistoricGame.getAssetFactory();
        this.hitCondition = requiredHistoricGame.getHitCondition();
        this.winCondition = requiredHistoricGame.getWinCondition();
    }

    @Override
    public void play() {
        Game game = new Game(
                dice,
                assets,
                hitCondition,
                winCondition
        );
        game.play();
    }
}
