package uk.ac.mmu.game.infrastructure.console.payload;

import uk.ac.mmu.game.domain.entities.Player;

public class OnWin {
    public Player player;
    public int turn;
    public int totalTurns;

    public OnWin(Player player, int turn, int totalTurns) {
        this.player = player;
        this.turn = turn;
        this.totalTurns = totalTurns;
    }
}
