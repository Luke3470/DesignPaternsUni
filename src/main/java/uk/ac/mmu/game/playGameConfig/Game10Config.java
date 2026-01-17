package uk.ac.mmu.game.playGameConfig;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import uk.ac.mmu.game.applicationcode.domain.dice.NonRandomDice;
import uk.ac.mmu.game.applicationcode.domain.factories.FourPlayerAssets;
import uk.ac.mmu.game.applicationcode.domain.rules.HitConditionOnePerSpace;
import uk.ac.mmu.game.applicationcode.domain.rules.WinConditionExact;
import uk.ac.mmu.game.applicationcode.usecase.RequiredAssetFactory;
import uk.ac.mmu.game.applicationcode.usecase.RequiredDice;
import uk.ac.mmu.game.applicationcode.usecase.RequiredHitCondition;
import uk.ac.mmu.game.applicationcode.usecase.RequiredWinCondition;
import uk.ac.mmu.game.applicationcode.usecase.play.PlayGameUseCase;
import uk.ac.mmu.game.applicationcode.usecase.play.ProvidedPlayGame;

@Order(10)
@Configuration
public class Game10Config {

    @PostConstruct
    public void init() {
        System.out.println("Loaded Game10Config");
    }

    @Bean
    @Scope("prototype")
    public RequiredDice diceGame10() {
        return () -> new NonRandomDice(new int[] {11,11,8,10,10,7,2,4,6,8,4,9,9,10,7,11,10,8,5,7});
    }

    @Bean
    @Scope("prototype")
    public RequiredAssetFactory assetFactoryGame10() {
        return FourPlayerAssets::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredHitCondition hitConditionGame10() {
        return HitConditionOnePerSpace::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredWinCondition winConditionGame10() {
        return WinConditionExact::new;
    }
    @Bean
    @Scope("prototype")
    public ProvidedPlayGame playUseCaseGame10(
            RequiredDice diceGame10,
            RequiredAssetFactory assetFactoryGame10,
            RequiredHitCondition hitConditionGame10,
            RequiredWinCondition winConditionGame10
    ) {
        return new PlayGameUseCase(diceGame10, assetFactoryGame10, hitConditionGame10, winConditionGame10);
    }
}
