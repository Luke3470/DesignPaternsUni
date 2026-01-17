package uk.ac.mmu.game.applicationcode.domain.factories;

import static uk.ac.mmu.game.domain.entities.Player.*;

public class FourPlayerFactory implements PlayerFactory{
    @Override
    public Player [] construct() {
        Player playerOne = PLAYER1;
        Player playerTwo = PLAYER2;
        playerOne.SetFinalTrackPos(35);
        playerTwo.SetFinalTrackPos(8);
        Player [] players = new Player[4];
        players[0] = playerOne;
        players[1] = playerTwo;
        players[2] = PLAYER3;
        players[3] = PLAYER4;
        return players;
    }
}
