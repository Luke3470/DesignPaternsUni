package uk.ac.mmu.game.infrastructure.driven.io;


import uk.ac.mmu.game.applicationcode.domain.dice.NonRandomDice;
import uk.ac.mmu.game.applicationcode.domain.factories.AssetFactory;
import uk.ac.mmu.game.applicationcode.domain.factories.FourPlayerAssets;
import uk.ac.mmu.game.applicationcode.domain.factories.TwoPlayerAssets;
import uk.ac.mmu.game.applicationcode.domain.rules.*;

import java.util.List;

class GameConfigFactory {

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
        int [] data = new int[rolls.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = rolls.get(i);
        }
        return new NonRandomDice(data);
    }
}
