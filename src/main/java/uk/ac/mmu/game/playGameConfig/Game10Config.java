package uk.ac.mmu.game.playGameConfig;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import uk.ac.mmu.game.applicationcode.domain.dice.NonRandomDice;
import uk.ac.mmu.game.applicationcode.domain.factories.TwoPlayerAssets;
import uk.ac.mmu.game.applicationcode.domain.rules.HitConditionStandard;
import uk.ac.mmu.game.applicationcode.domain.rules.WinConditionStandard;
import uk.ac.mmu.game.applicationcode.usecase.RequiredAssetFactory;
import uk.ac.mmu.game.applicationcode.usecase.RequiredDice;
import uk.ac.mmu.game.applicationcode.usecase.RequiredHitCondition;
import uk.ac.mmu.game.applicationcode.usecase.RequiredWinCondition;
import uk.ac.mmu.game.applicationcode.usecase.play.PlayGameUseCase;
import uk.ac.mmu.game.applicationcode.usecase.play.Provided;


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
        return () -> new NonRandomDice(new int[]{12,12,7,8,12,12});
    }

    @Bean
    @Scope("prototype")
    public RequiredAssetFactory assetFactoryGame10() {
        return TwoPlayerAssets::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredHitCondition hitConditionGame10() {
        return HitConditionStandard::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredWinCondition winConditionGame10() {
        return WinConditionStandard::new;
    }
    @Bean
    @Scope("prototype")
    public Provided playUseCaseGame10(
            RequiredDice diceGame10,
            RequiredAssetFactory assetFactoryGame10,
            RequiredHitCondition hitConditionGame10,
            RequiredWinCondition winConditionGame10
    ) {
        return new PlayGameUseCase(diceGame10, assetFactoryGame10, hitConditionGame10, winConditionGame10);
    }
}
