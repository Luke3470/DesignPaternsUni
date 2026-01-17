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
import uk.ac.mmu.game.applicationcode.usecase.play.ProvidedPlayGame;

@Order(7)
@Configuration
public class Game7Config {

  @PostConstruct
  public void init() {
    System.out.println("Loaded Game7Config");
  }

  @Bean
  @Scope("prototype")
  public RequiredDice diceGame7() {
    return () -> new NonRandomDice(new int[]{12, 12, 12, 9, 8});
  }

  @Bean
  @Scope("prototype")
  public RequiredAssetFactory assetFactoryGame7() {
    return TwoPlayerAssets::new;
  }

  @Bean
  @Scope("prototype")
  public RequiredHitCondition hitConditionGame7() {
    return HitConditionOnePerSpace::new;
  }

  @Bean
  @Scope("prototype")
  public RequiredWinCondition winConditionGame7() {
    return WinConditionExact::new;
  }

  @Bean
  @Scope("prototype")
  public ProvidedPlayGame playUseCaseGame7(
      RequiredDice diceGame7,
      RequiredAssetFactory assetFactoryGame7,
      RequiredHitCondition hitConditionGame7,
      RequiredWinCondition winConditionGame7
  ) {
    return new PlayGameUseCase(diceGame7, assetFactoryGame7, hitConditionGame7, winConditionGame7);
  }
}
