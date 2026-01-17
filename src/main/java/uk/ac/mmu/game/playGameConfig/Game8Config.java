package uk.ac.mmu.game.playGameConfig;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import uk.ac.mmu.game.applicationcode.domain.dice.NonRandomDice;
import uk.ac.mmu.game.applicationcode.domain.factories.TwoPlayerAssets;
import uk.ac.mmu.game.applicationcode.domain.rules.HitConditionOnePerSpace;
import uk.ac.mmu.game.applicationcode.domain.rules.WinConditionExact;
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
        return () -> new NonRandomDice(new int[]{8,2,3,12,9,6});
    }

    @Bean
    @Scope("prototype")
    public RequiredAssetFactory assetFactoryGame8() {
        return TwoPlayerAssets::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredHitCondition hitConditionGame8() {
        return HitConditionOnePerSpace::new;
    }

    @Bean
    @Scope("prototype")
    public RequiredWinCondition winConditionGame8() {
        return WinConditionExact::new;
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
