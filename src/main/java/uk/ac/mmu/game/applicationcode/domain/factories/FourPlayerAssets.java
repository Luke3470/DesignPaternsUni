package uk.ac.mmu.game.applicationcode.domain.factories;

import uk.ac.mmu.game.applicationcode.domain.board.Board;
import uk.ac.mmu.game.applicationcode.domain.player.BasicPlayerSelector;
import uk.ac.mmu.game.applicationcode.domain.player.PlayerIterable;

public class FourPlayerAssets implements AssetFactory {
    @Override
    public PlayerIterable createPlayers() {
        return new PlayerIterable(new BasicPlayerSelector(new FourPlayerFactory().construct()));
    }

    @Override
    public Board createBoard() {
        return new FourPlayerBoardFactory().create();
    }
    @Override
    public String toString(){
        return "FourPlayerAssets";
    }
}

