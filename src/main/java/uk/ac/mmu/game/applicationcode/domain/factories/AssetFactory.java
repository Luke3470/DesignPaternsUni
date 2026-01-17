package uk.ac.mmu.game.applicationcode.domain.factories;

public interface AssetFactory {
    PlayerIterable createPlayers();
    Board createBoard();
}
