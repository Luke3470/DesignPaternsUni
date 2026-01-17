package uk.ac.mmu.game.applicationcode.domain.factories;

import static uk.ac.mmu.game.domain.entities.Player.*;

public class FourPlayerBoardFactory implements BoardFactory {
    @Override
    public Board create() {
        Player[] p = {PLAYER1,PLAYER2,PLAYER3,PLAYER4};
        Board b = new StandardBoard(36,6,p);
        return b;
    }

}
