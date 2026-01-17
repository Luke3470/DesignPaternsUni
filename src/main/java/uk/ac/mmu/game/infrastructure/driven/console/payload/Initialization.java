package uk.ac.mmu.game.infrastructure.driven.console.payload;


import uk.ac.mmu.game.applicationcode.domain.dice.Dice;
import uk.ac.mmu.game.applicationcode.domain.factories.AssetFactory;
import uk.ac.mmu.game.applicationcode.domain.rules.HitCondition;
import uk.ac.mmu.game.applicationcode.domain.rules.WinCondition;

public class Initialization {

  final public HitCondition hitCondition;
  final public WinCondition winCondition;
  final public AssetFactory assetFactory;
  final public Dice dice;

  public Initialization(HitCondition hitCondition, WinCondition winCondition, AssetFactory assets,
      Dice dice) {
    this.hitCondition = hitCondition;
    this.winCondition = winCondition;
    this.dice = dice;
    this.assetFactory = assets;
  }
}
