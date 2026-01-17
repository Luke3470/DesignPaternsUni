package uk.ac.mmu.game.applicationcode.domain.factories;

import static uk.ac.mmu.game.applicationcode.domain.entities.Player.PLAYER1;
import static uk.ac.mmu.game.applicationcode.domain.entities.Player.PLAYER2;

import uk.ac.mmu.game.applicationcode.domain.board.Board;
import uk.ac.mmu.game.applicationcode.domain.board.BoardFactory;
import uk.ac.mmu.game.applicationcode.domain.board.StandardBoard;
import uk.ac.mmu.game.applicationcode.domain.entities.Player;


class TwoPlayerBoardFactory implements BoardFactory {

  @Override
  public Board create() {
    Player[] players = {PLAYER1, PLAYER2};
    Board b = new StandardBoard(18, 3, players);
    return b;
  }
}
