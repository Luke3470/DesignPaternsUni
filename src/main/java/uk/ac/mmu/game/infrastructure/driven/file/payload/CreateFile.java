package uk.ac.mmu.game.infrastructure.driven.file.payload;


import java.util.List;
import uk.ac.mmu.game.applicationcode.domain.dice.Types.RollValue;
import uk.ac.mmu.game.applicationcode.domain.factories.AssetFactory;
import uk.ac.mmu.game.applicationcode.domain.rules.HitCondition;
import uk.ac.mmu.game.applicationcode.domain.rules.WinCondition;

public class CreateFile {

  final public HitCondition hitCondition;
  final public WinCondition winCondition;
  final public List<RollValue> rolls;
  final public AssetFactory assets;

  public CreateFile(HitCondition hitCondition, WinCondition winCondition, List<RollValue> rolls,
      AssetFactory assets) {
    this.hitCondition = hitCondition;
    this.winCondition = winCondition;
    this.rolls = rolls;
    this.assets = assets;
  }

}
