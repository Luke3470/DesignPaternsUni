package uk.ac.mmu.game.applicationcode.domain.factories;

import uk.ac.mmu.game.applicationcode.domain.entities.Player;
import uk.ac.mmu.game.applicationcode.domain.player.PlayerFactory;

import static uk.ac.mmu.game.applicationcode.domain.entities.Player.PLAYER1;
import static uk.ac.mmu.game.applicationcode.domain.entities.Player.PLAYER2;


public class TwoPlayerFactory implements PlayerFactory {
    @Override
    public Player[] construct() {
        Player playerOne = PLAYER1;
        Player playerTwo = PLAYER2;
        playerOne.SetFinalTrackPos(17);
        playerTwo.SetFinalTrackPos(8);
        Player [] players = new Player[2];
        players[0] = playerOne;
        players[1] = playerTwo;
        return players;
    }
}
