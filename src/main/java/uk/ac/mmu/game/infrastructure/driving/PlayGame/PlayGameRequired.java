package uk.ac.mmu.game.infrastructure.driving.PlayGame;

import uk.ac.mmu.game.applicationcode.domain.dice.Dice;
import uk.ac.mmu.game.applicationcode.domain.factories.AssetFactory;
import uk.ac.mmu.game.applicationcode.domain.rules.HitCondition;
import uk.ac.mmu.game.applicationcode.domain.rules.WinCondition;
import uk.ac.mmu.game.applicationcode.usecase.RequiredAssetFactory;
import uk.ac.mmu.game.applicationcode.usecase.RequiredDice;
import uk.ac.mmu.game.applicationcode.usecase.RequiredHitCondition;
import uk.ac.mmu.game.applicationcode.usecase.RequiredWinCondition;

public class PlayGameRequired implements RequiredDice, RequiredAssetFactory, RequiredWinCondition,
    RequiredHitCondition {

  private final Dice dice;
  private final AssetFactory assetFactory;
  private final HitCondition hitCondition;
  private final WinCondition winCondition;

  public PlayGameRequired(Dice dice, AssetFactory assetFactory, HitCondition hitCondition,
      WinCondition winCondition) {
    this.dice = dice;
    this.assetFactory = assetFactory;
    this.hitCondition = hitCondition;
    this.winCondition = winCondition;
  }

  @Override
  public Dice getDice() {
    return dice;
  }


  @Override
  public AssetFactory getAssetFactory() {
    return assetFactory;
  }

  @Override
  public HitCondition getHitCondition() {
    return hitCondition;
  }

  @Override
  public WinCondition getWinCondition() {
    return winCondition;
  }
}
