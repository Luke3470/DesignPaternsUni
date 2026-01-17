package uk.ac.mmu.game.applicationcode.domain.factories;

import static uk.ac.mmu.game.domain.entities.Player.PLAYER1;
import static uk.ac.mmu.game.domain.entities.Player.PLAYER2;

public class TwoPlayerBoardFactory implements BoardFactory{
    @Override
    public Board create() {
        Player[] players = {PLAYER1,PLAYER2};
        Board b = new StandardBoard(18,3,players);
        return b;
    }
}
