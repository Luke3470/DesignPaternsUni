package uk.ac.mmu.game.infrastructure.driving.PlayHistoric.io;

import java.util.List;

public class GameConfig {

    private final String hitConditionName;
    private final String winConditionName;
    private final String assetName;
    private final List<Integer> numbers;

    public GameConfig(String hitConditionName, String winConditionName, String assetName, List<Integer> numbers) {
        this.hitConditionName = hitConditionName;
        this.winConditionName = winConditionName;
        this.assetName = assetName;
        this.numbers = numbers;
    }

    public String getHitConditionName() { return hitConditionName; }
    public String getWinConditionName() { return winConditionName; }
    public String getAssetName() { return assetName; }
    public List<Integer> getNumbers() { return numbers; }
}
