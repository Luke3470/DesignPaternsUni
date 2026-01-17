package uk.ac.mmu.game.applicationcode.usecase.playhistoric;

import uk.ac.mmu.game.applicationcode.usecase.*;

public interface ProvidedPlayHistoric {
    void play();

    static ProvidedPlayHistoric getInstance(RequiredHistoricGame requiredHistoricGame) {
        return new PlayHistoricUseCase(requiredHistoricGame);
    }
}