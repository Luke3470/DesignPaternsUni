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

@Order(4)
@Configuration
public class Game4Config {

    @PostConstruct
    public void init() {
        System.out.println("Loaded Game4Config");
    }

    @Bean
    @Qualifier("diceGame4")
    @Scope("prototype")
    public RequiredDice diceGame4() {
        return () -> new NonRandomDice(new int[]{12, 12, 7, 11});
    }

    @Bean
    @Qualifier("assetFactoryGame4")
    @Scope("prototype")
    public RequiredAssetFactory assetFactoryGame4() {
        return TwoPlayerAssets::new;
    }

    @Bean
    @Qualifier("hitConditionGame4")
    @Scope("prototype")
    public RequiredHitCondition hitConditionGame4() {
        return HitConditionStandard::new;
    }

    @Bean
    @Qualifier("winConditionGame4")
    @Scope("prototype")
    public RequiredWinCondition winConditionGame4() {
        return WinConditionStandard::new;
    }
    @Bean
    @Scope("prototype")
    public Provided playUseCaseGame4(
            @Qualifier("diceGame4") RequiredDice diceGame4,
            @Qualifier("assetFactoryGame4") RequiredAssetFactory assetFactoryGame4,
            @Qualifier("hitConditionGame4") RequiredHitCondition hitConditionGame4,
            @Qualifier("winConditionGame4") RequiredWinCondition winConditionGame4
    ) {
        return new PlayGameUseCase(diceGame4, assetFactoryGame4, hitConditionGame4, winConditionGame4);
    }
}
