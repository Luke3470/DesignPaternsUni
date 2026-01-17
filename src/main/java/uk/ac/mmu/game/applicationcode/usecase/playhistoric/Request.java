package uk.ac.mmu.game.applicationcode.usecase.playhistoric;

import uk.ac.mmu.game.applicationcode.domain.dice.Dice;
import uk.ac.mmu.game.applicationcode.domain.factories.AssetFactory;
import uk.ac.mmu.game.applicationcode.domain.rules.HitCondition;
import uk.ac.mmu.game.applicationcode.domain.rules.WinCondition;

public class Request {

  private final Dice dice;
  private final AssetFactory assets;
  private final HitCondition hitCondition;
  private final WinCondition winCondition;

  public Request(Dice dice, AssetFactory assets, HitCondition hitCondition,
      WinCondition winCondition) {
    // Should add Validation but Non is required Just and Example of how it should look

    this.dice = dice;
    this.assets = assets;
    this.hitCondition = hitCondition;
    this.winCondition = winCondition;
  }

  public Dice getDice() {
    return dice;
  }

  public HitCondition getHitCondition() {
    return hitCondition;
  }

  public AssetFactory getAssetFactory() {
    return assets;
  }

  public WinCondition getWinCondition() {
    return winCondition;
  }
}
