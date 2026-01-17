package uk.ac.mmu.game.playGameConfig;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import uk.ac.mmu.game.applicationcode.domain.dice.NonRandomDice;
import uk.ac.mmu.game.applicationcode.domain.factories.FourPlayerAssets;
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

@Order(8)
@Configuration
public class Game8Config {

    @PostConstruct
    public void init() {
        System.out.println("Loaded Game8Config");
    }

    @Bean
    @Scope("prototype")
    public RequiredDice diceGame8() {
        return () -> new NonRandomDice(new int[] {7,3,8,5,7,6,8,7,6,8,2,4,4,8,5,7,8,3,9,9,7,5,7,9});
    }

    @Bean
    @Scope("prototype")
    public RequiredAssetFactory assetFactoryGame8() {
        return FourPlayerAssets::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredHitCondition hitConditionGame8() {
        return HitConditionStandard::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredWinCondition winConditionGame8() {
        return WinConditionStandard::new;
    }
    @Bean
    @Scope("prototype")
    public Provided playUseCaseGame8(
            RequiredDice diceGame8,
            RequiredAssetFactory assetFactoryGame8,
            RequiredHitCondition hitConditionGame8,
            RequiredWinCondition winConditionGame8
    ) {
        return new PlayGameUseCase(diceGame8, assetFactoryGame8, hitConditionGame8, winConditionGame8);
    }
}
