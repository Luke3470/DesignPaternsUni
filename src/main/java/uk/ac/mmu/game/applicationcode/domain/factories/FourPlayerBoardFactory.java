package uk.ac.mmu.game.applicationcode.domain.factories;

import uk.ac.mmu.game.applicationcode.domain.board.Board;
import uk.ac.mmu.game.applicationcode.domain.board.BoardFactory;
import uk.ac.mmu.game.applicationcode.domain.board.StandardBoard;
import uk.ac.mmu.game.applicationcode.domain.entities.Player;

import static uk.ac.mmu.game.applicationcode.domain.entities.Player.*;

class FourPlayerBoardFactory implements BoardFactory {
    @Override
    public Board create() {
        Player[] p = {PLAYER1,PLAYER2,PLAYER3,PLAYER4};
        Board b = new StandardBoard(36,6,p);
        return b;
    }

}
