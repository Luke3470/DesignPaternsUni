package uk.ac.mmu.game.infrastructure.driving.PlayGame;

import org.springframework.stereotype.Component;
import uk.ac.mmu.game.applicationcode.usecase.play.Provided;

@Component
public class PlayGameInitializer implements org.springframework.boot.CommandLineRunner, org.springframework.core.Ordered {

    private final Provided provided;

    public PlayGameInitializer(Provided provided) {
        this.provided = provided;
    }


    @Override
    public void run(String... args){
        provided.play();
    }

    @Override
    public int getOrder() {
        return org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
    }
}
