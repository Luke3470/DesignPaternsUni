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
import uk.ac.mmu.game.applicationcode.usecase.play.Provided;

@Order(9)
@Configuration
public class Game9Config {

    @PostConstruct
    public void init() {
        System.out.println("Loaded Game9Config");
    }

    @Bean
    @Scope("prototype")
    public RequiredDice diceGame9() {
        return () -> new NonRandomDice(new int[] {11,11,8,10,10,7,2,4,6,8,4,9,9,10,7,11,10,8,5,7});
    }

    @Bean
    @Scope("prototype")
    public RequiredAssetFactory assetFactoryGame9() {
        return FourPlayerAssets::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredHitCondition hitConditionGame9() {
        return HitConditionOnePerSpace::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredWinCondition winConditionGame9() {
        return WinConditionExact::new;
    }
    @Bean
    @Scope("prototype")
    public Provided playUseCaseGame9(
            RequiredDice diceGame9,
            RequiredAssetFactory assetFactoryGame9,
            RequiredHitCondition hitConditionGame9,
            RequiredWinCondition winConditionGame9
    ) {
        return new PlayGameUseCase(diceGame9, assetFactoryGame9, hitConditionGame9, winConditionGame9);
    }
}
