package uk.ac.mmu.game.applicationcode.domain.factories;

import uk.ac.mmu.game.applicationcode.domain.board.Board;
import uk.ac.mmu.game.applicationcode.domain.player.BasicPlayerSelector;
import uk.ac.mmu.game.applicationcode.domain.player.PlayerIterable;

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
  public String toString() {
    return "TwoPlayerAssets";
  }
}
