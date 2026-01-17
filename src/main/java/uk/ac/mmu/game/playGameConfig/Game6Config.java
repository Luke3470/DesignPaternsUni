package uk.ac.mmu.game.playGameConfig;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import uk.ac.mmu.game.applicationcode.domain.dice.NonRandomDice;
import uk.ac.mmu.game.applicationcode.domain.factories.TwoPlayerAssets;
import uk.ac.mmu.game.applicationcode.domain.rules.HitConditionOnePerSpace;
import uk.ac.mmu.game.applicationcode.domain.rules.HitConditionStandard;
import uk.ac.mmu.game.applicationcode.domain.rules.WinConditionExact;
import uk.ac.mmu.game.applicationcode.domain.rules.WinConditionStandard;
import uk.ac.mmu.game.applicationcode.usecase.RequiredAssetFactory;
import uk.ac.mmu.game.applicationcode.usecase.RequiredDice;
import uk.ac.mmu.game.applicationcode.usecase.RequiredHitCondition;
import uk.ac.mmu.game.applicationcode.usecase.RequiredWinCondition;
import uk.ac.mmu.game.applicationcode.usecase.play.PlayGameUseCase;
import uk.ac.mmu.game.applicationcode.usecase.play.Provided;

@Order(6)
@Configuration
public class Game6Config {

    @PostConstruct
    public void init() {
        System.out.println("Loaded Game6Config");
    }


    @Bean
    @Scope("prototype")
    public RequiredDice diceGame6() {
        return () -> new NonRandomDice(new int[]{12,12,12,9,8});
    }

    @Bean
    @Scope("prototype")
    public RequiredAssetFactory assetFactoryGame6() {
        return TwoPlayerAssets::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredHitCondition hitConditionGame6() {
        return HitConditionOnePerSpace::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredWinCondition winConditionGame6() {
        return WinConditionExact::new;
    }
    @Bean
    @Scope("prototype")
    public Provided playUseCaseGame6(
            RequiredDice diceGame6,
            RequiredAssetFactory assetFactoryGame6,
            RequiredHitCondition hitConditionGame6,
            RequiredWinCondition winConditionGame6
    ) {
        return new PlayGameUseCase(diceGame6, assetFactoryGame6, hitConditionGame6, winConditionGame6);
    }
}
