package uk.ac.mmu.game.infrastructure.driving.PlayHistoric.io;

import java.util.List;

public record GameConfig(String hitConditionName, String winConditionName, String assetName,
                         List<Integer> numbers) {

}
