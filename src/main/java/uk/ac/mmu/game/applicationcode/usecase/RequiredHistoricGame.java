package uk.ac.mmu.game.applicationcode.usecase;

import uk.ac.mmu.game.applicationcode.domain.dice.Dice;
import uk.ac.mmu.game.applicationcode.domain.factories.AssetFactory;
import uk.ac.mmu.game.applicationcode.domain.rules.HitCondition;
import uk.ac.mmu.game.applicationcode.domain.rules.WinCondition;

public interface RequiredHistoricGame {

  Dice getDice();

  AssetFactory getAssetFactory();

  HitCondition getHitCondition();

  WinCondition getWinCondition();
}
