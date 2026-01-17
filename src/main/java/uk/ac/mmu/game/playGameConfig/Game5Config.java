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
import uk.ac.mmu.game.applicationcode.usecase.play.ProvidedPlayGame;

@Order(5)
@Configuration
public class Game5Config {

  @PostConstruct
  public void init() {
    System.out.println("Loaded Game5Config");
  }

  @Bean
  @Qualifier("diceGame5")
  @Scope("prototype")
  public RequiredDice diceGame5() {
    return () -> new NonRandomDice(new int[]{6, 6, 6, 6, 3, 4, 3, 4});
  }

  @Bean
  @Qualifier("assetFactoryGame5")
  @Scope("prototype")
  public RequiredAssetFactory assetFactoryGame5() {
    return TwoPlayerAssets::new;
  }

  @Bean
  @Qualifier("hitConditionGame5")
  @Scope("prototype")
  public RequiredHitCondition hitConditionGame5() {
    return HitConditionStandard::new;
  }

  @Bean
  @Qualifier("winConditionGame5")
  @Scope("prototype")
  public RequiredWinCondition winConditionGame5() {
    return WinConditionStandard::new;
  }

  @Bean
  @Scope("prototype")
  public ProvidedPlayGame playUseCaseGame5(
      RequiredDice diceGame5,
      RequiredAssetFactory assetFactoryGame5,
      RequiredHitCondition hitConditionGame5,
      RequiredWinCondition winConditionGame5
  ) {
    return new PlayGameUseCase(diceGame5, assetFactoryGame5, hitConditionGame5, winConditionGame5);
  }
}
