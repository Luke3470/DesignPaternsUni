package uk.ac.mmu.game.infrastructure.driving.PlayHistoric;

import java.io.IOException;
import uk.ac.mmu.game.applicationcode.domain.dice.Dice;
import uk.ac.mmu.game.applicationcode.domain.factories.AssetFactory;
import uk.ac.mmu.game.applicationcode.domain.rules.HitCondition;
import uk.ac.mmu.game.applicationcode.domain.rules.WinCondition;
import uk.ac.mmu.game.applicationcode.usecase.RequiredHistoricGame;
import uk.ac.mmu.game.infrastructure.driving.PlayHistoric.io.ConfigReader;
import uk.ac.mmu.game.infrastructure.driving.PlayHistoric.io.GameConfig;
import uk.ac.mmu.game.infrastructure.driving.PlayHistoric.io.GameConfigFactory;

public class PlayHistoricRequired implements RequiredHistoricGame {

  private final Dice dice;
  private final AssetFactory assetFactory;
  private final HitCondition hitCondition;
  private final WinCondition winCondition;

  public PlayHistoricRequired(String id) throws IOException {
    String savePath = (System.getProperty("user.dir") + "\\Games\\");
    GameConfig config = ConfigReader.load(savePath + id);
    if (config == null) {
      throw new IOException("No such game");
    }
    GameConfigFactory factory = new GameConfigFactory();
    this.dice = factory.CreateDice(config.numbers());
    this.assetFactory = factory.createAssets(config.assetName());
    this.hitCondition = factory.createHitCondition(config.hitConditionName());
    this.winCondition = factory.createWinCondition(config.winConditionName());
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
