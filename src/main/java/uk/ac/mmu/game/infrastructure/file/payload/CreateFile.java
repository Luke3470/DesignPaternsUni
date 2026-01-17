package uk.ac.mmu.game.infrastructure.file.payload;


import uk.ac.mmu.game.applicationcode.domain.dice.Types.RollValue;
import uk.ac.mmu.game.applicationcode.domain.factories.AssetFactory;
import uk.ac.mmu.game.applicationcode.domain.rules.HitCondition;
import uk.ac.mmu.game.applicationcode.domain.rules.WinCondition;

import java.util.List;

public class CreateFile {
    public HitCondition hitCondition;
    public WinCondition winCondition;
    public List<RollValue> rolls;
    public AssetFactory assets;

    public CreateFile(HitCondition hitCondition, WinCondition winCondition, List<RollValue> rolls, AssetFactory assets) {
        this.hitCondition = hitCondition;
        this.winCondition = winCondition;
        this.rolls = rolls;
        this.assets = assets;
    }

}
