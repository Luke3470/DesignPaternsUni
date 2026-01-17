package uk.ac.mmu.game.PlayHistoricConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import uk.ac.mmu.game.applicationcode.usecase.RequiredHistoricGame;
import uk.ac.mmu.game.infrastructure.driving.PlayHistoric.PlayHistoricRequired;


import java.io.IOException;

@Configuration
public class HistoricGameConfig {

    @Bean
    @Scope("prototype")
    public RequiredHistoricGame playHistoricGame1() throws IOException {
        return new PlayHistoricRequired("0ae3a243-e6e2-4b82-8b47-7cd57a4ee046");
    }

}