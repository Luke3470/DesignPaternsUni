package uk.ac.mmu.game.infrastructure.console.payload;

import Game.Dice.Dice;
import Game.Rules.HitCondition;
import Game.Rules.WinCondition;


public class Initialization {
    public HitCondition hitCondition;
    public WinCondition winCondition;
    public AssetFactory assetFactory;
    public Dice dice;

    public Initialization(HitCondition hitCondition, WinCondition winCondition, AssetFactory assets, Dice dice) {
        this.hitCondition = hitCondition;
        this.winCondition = winCondition;
        this.dice = dice;
        this.assetFactory = assets;
    }
}
