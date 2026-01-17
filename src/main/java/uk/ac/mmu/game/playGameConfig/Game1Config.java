package uk.ac.mmu.game.playGameConfig;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
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

@Order(1)
@Configuration
public class Game1Config {

    @PostConstruct
    public void init() {
        System.out.println("Loaded Game1Config");
    }

    @Bean
    @Scope("prototype")
    public RequiredDice diceGame1() {
        return () -> new NonRandomDice(new int[]{12, 12, 7, 8});
    }

    @Bean
    @Scope("prototype")
    public RequiredAssetFactory assetFactoryGame1() {
        return TwoPlayerAssets::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredHitCondition hitConditionGame1() {
        return HitConditionStandard::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredWinCondition winConditionGame1() {
        return WinConditionStandard::new;
    }
    @Bean
    @Scope("prototype")
    public Provided playUseCaseGame1(
            RequiredDice diceGame1,
            RequiredAssetFactory assetFactoryGame1,
            RequiredHitCondition hitConditionGame1,
            RequiredWinCondition winConditionGame1
    ) {
        return new PlayGameUseCase(diceGame1, assetFactoryGame1, hitConditionGame1, winConditionGame1);
    }
}
