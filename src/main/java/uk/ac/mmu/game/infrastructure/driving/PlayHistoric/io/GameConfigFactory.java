package uk.ac.mmu.game.infrastructure.driving.PlayHistoric.io;


import java.util.List;
import uk.ac.mmu.game.applicationcode.domain.dice.NonRandomDice;
import uk.ac.mmu.game.applicationcode.domain.factories.AssetFactory;
import uk.ac.mmu.game.applicationcode.domain.factories.FourPlayerAssets;
import uk.ac.mmu.game.applicationcode.domain.factories.TwoPlayerAssets;
import uk.ac.mmu.game.applicationcode.domain.rules.HitCondition;
import uk.ac.mmu.game.applicationcode.domain.rules.HitConditionOnePerSpace;
import uk.ac.mmu.game.applicationcode.domain.rules.HitConditionStandard;
import uk.ac.mmu.game.applicationcode.domain.rules.WinCondition;
import uk.ac.mmu.game.applicationcode.domain.rules.WinConditionExact;
import uk.ac.mmu.game.applicationcode.domain.rules.WinConditionStandard;

public class GameConfigFactory {

  public HitCondition createHitCondition(String name) {
    return switch (name) {
      case "HitConditionStandard" -> new HitConditionStandard();
      case "HitConditionOnePerSpace" -> new HitConditionOnePerSpace();
      default -> throw new IllegalArgumentException("Unknown HitCondition: " + name);
    };
  }

  public WinCondition createWinCondition(String name) {
    return switch (name) {
      case "WinConditionStandard" -> new WinConditionStandard();
      case "WinConditionExact" -> new WinConditionExact();
      default -> throw new IllegalArgumentException("Unknown WinCondition: " + name);
    };
  }

  public AssetFactory createAssets(String name) {
    return switch (name) {
      case "TwoPlayerAssets" -> new TwoPlayerAssets();
      case "FourPlayerAssets" -> new FourPlayerAssets();
      default -> throw new IllegalArgumentException("Unknown Asset: " + name);
    };
  }

  public NonRandomDice CreateDice(List<Integer> rolls) {
    int[] data = new int[rolls.size()];
    for (int i = 0; i < data.length; i++) {
      data[i] = rolls.get(i);
    }
    return new NonRandomDice(data);
  }
}
