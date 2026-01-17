package uk.ac.mmu.game.infrastructure.file.payload;

import Game.Dice.Types.RollValue;
import Game.Rules.HitCondition;
import Game.Rules.WinCondition;

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
