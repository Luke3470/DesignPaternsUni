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

@Order(2)
@Configuration
public class Game2Config {

  @PostConstruct
  public void init() {
    System.out.println("Loaded Game2Config");
  }

  @Bean
  @Scope("prototype")
  public RequiredDice diceGame2() {
    return () -> new NonRandomDice(new int[]{12, 12, 6, 6, 2});
  }

  @Bean
  @Scope("prototype")
  public RequiredAssetFactory assetFactoryGame2() {
    return TwoPlayerAssets::new;
  }

  @Bean
  @Scope("prototype")
  public RequiredHitCondition hitConditionGame2() {
    return HitConditionStandard::new;
  }

  @Bean
  @Qualifier("winConditionGame2")
  @Scope("prototype")
  public RequiredWinCondition winConditionGame2() {
    return WinConditionStandard::new;
  }

  @Bean
  public ProvidedPlayGame playUseCaseGame2(
      RequiredDice diceGame2,
      RequiredAssetFactory assetFactoryGame2,
      RequiredHitCondition hitConditionGame2,
      RequiredWinCondition winConditionGame2
  ) {
    return new PlayGameUseCase(diceGame2, assetFactoryGame2, hitConditionGame2, winConditionGame2);
  }
}
