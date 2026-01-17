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
import uk.ac.mmu.game.applicationcode.usecase.play.ProvidedPlayGame;

@Order(3)
@Configuration
public class Game3Config {

    @PostConstruct
    public void init() {
        System.out.println("Loaded Game3Config");
    }

    @Bean
    @Scope("prototype")
    public RequiredDice diceGame3() {
        return () -> new NonRandomDice(new int[]{8, 2, 3, 4, 9});
    }

    @Bean
    @Scope("prototype")
    public RequiredAssetFactory assetFactoryGame3() {
        return TwoPlayerAssets::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredHitCondition hitConditionGame3() {
        return HitConditionStandard::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredWinCondition winConditionGame3() {
        return WinConditionStandard::new;
    }
    @Bean
    @Scope("prototype")
    public ProvidedPlayGame playUseCaseGame3(
            RequiredDice diceGame3,
            RequiredAssetFactory assetFactoryGame3,
            RequiredHitCondition hitConditionGame3,
            RequiredWinCondition winConditionGame3
    ) {
        return new PlayGameUseCase(diceGame3, assetFactoryGame3, hitConditionGame3, winConditionGame3);
    }
}
