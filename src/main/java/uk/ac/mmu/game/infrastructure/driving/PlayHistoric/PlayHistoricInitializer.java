package uk.ac.mmu.game.infrastructure.driving.PlayHistoric;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import uk.ac.mmu.game.applicationcode.usecase.RequiredHistoricGame;

import uk.ac.mmu.game.applicationcode.usecase.playhistoric.ProvidedPlayHistoric;

@Component
public class PlayHistoricInitializer implements CommandLineRunner, Ordered {

    private final RequiredHistoricGame historicGame;

    public PlayHistoricInitializer(RequiredHistoricGame historicGame) {
        this.historicGame = historicGame;
    }

    @Override
    public void run(String... args) {
        System.out.println("=== Starting Historic Game ===");
        ProvidedPlayHistoric.getInstance(historicGame).play();
    }

    @Override
    public int getOrder() {
        // Ensures it runs after normal games
        return Ordered.LOWEST_PRECEDENCE;
    }
}
