package uk.ac.mmu.game.infrastructure.driving.PlayGame;

import org.springframework.stereotype.Component;
import uk.ac.mmu.game.applicationcode.usecase.play.Provided;

import java.util.List;

@Component
public class PlayGameInitializer implements org.springframework.boot.CommandLineRunner, org.springframework.core.Ordered {

    private final List<Provided> games;

    public PlayGameInitializer(List<Provided> games) {
        this.games = games;
    }


    @Override
    public void run(String... args){
        for (int i = 0; i < games.size(); i++) {
            System.out.println("=== Starting Game " + (i + 1) + " ===");
            games.get(i).play();
        }
    }

    @Override
    public int getOrder() {
        return org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
    }
}
