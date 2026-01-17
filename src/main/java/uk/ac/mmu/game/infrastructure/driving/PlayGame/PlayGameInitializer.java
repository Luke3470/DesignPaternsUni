package uk.ac.mmu.game.infrastructure.driving.PlayGame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import uk.ac.mmu.game.applicationcode.usecase.play.Provided;

@Component
public class PlayGameInitializer implements org.springframework.boot.CommandLineRunner, org.springframework.core.Ordered {

    @Autowired
    private ApplicationContext context;

    public PlayGameInitializer(ApplicationContext context) {
        this.context = context;
    }


    @Override
    public void run(String... args){
        for (int i = 1; i <= 11; i++) {
            System.out.println("=== Starting Game " + i + " ===");
            Provided game = context.getBean("playUseCaseGame" + i, Provided.class);
            game.play();
        }
    }

    @Override
    public int getOrder() {
        return org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
    }
}
