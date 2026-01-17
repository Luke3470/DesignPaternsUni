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


@Order(11)
@Configuration
public class Game11Config {

    @PostConstruct
    public void init() {
        System.out.println("Loaded Game11Config");
    }

    @Bean
    @Scope("prototype")
    public RequiredDice diceGame11() {
        return () -> new NonRandomDice(new int[]{12,12,7,8,12,12});
    }

    @Bean
    @Scope("prototype")
    public RequiredAssetFactory assetFactoryGame11() {
        return TwoPlayerAssets::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredHitCondition hitConditionGame11() {
        return HitConditionStandard::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredWinCondition winConditionGame11() {
        return WinConditionStandard::new;
    }
    @Bean
    @Scope("prototype")
    public Provided playUseCaseGame11(
            RequiredDice diceGame11,
            RequiredAssetFactory assetFactoryGame11,
            RequiredHitCondition hitConditionGame11,
            RequiredWinCondition winConditionGame11
    ) {
        return new PlayGameUseCase(diceGame11, assetFactoryGame11, hitConditionGame11, winConditionGame11);
    }
}
