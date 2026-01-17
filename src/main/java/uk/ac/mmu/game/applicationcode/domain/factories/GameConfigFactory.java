package uk.ac.mmu.game.applicationcode.domain.factories;

import Game.Assets.*;
import Game.Dice.NonRandomDice;
import Game.Rules.*;

import java.util.List;

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
        int [] data = new int[rolls.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = rolls.get(i);
        }
        return new NonRandomDice(data);
    }
}
