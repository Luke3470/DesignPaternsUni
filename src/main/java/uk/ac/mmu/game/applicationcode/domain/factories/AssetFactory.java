package uk.ac.mmu.game.applicationcode.domain.factories;

import uk.ac.mmu.game.applicationcode.domain.board.Board;
import uk.ac.mmu.game.applicationcode.domain.player.PlayerIterable;

public interface AssetFactory {
    PlayerIterable createPlayers();
    Board createBoard();
}
