package uk.ac.mmu.game.applicationcode.domain.factories;

public class TwoPlayerAssets implements AssetFactory {
    @Override
    public PlayerIterable createPlayers() {
        return new PlayerIterable(new BasicPlayerSelector(new TwoPlayerFactory().construct()));
    }

    @Override
    public Board createBoard() {
        return new TwoPlayerBoardFactory().create();
    }
    @Override
    public String toString(){
        return "TwoPlayerAssets";
    }
}
