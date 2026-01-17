package uk.ac.mmu.game.infrastructure.console.payload;

import uk.ac.mmu.game.domain.entities.Player;

public class OnRoll {
    public Player player;
    public int roll;

    public OnRoll(Player player, int roll) {
        this.player = player;
        this.roll = roll;
    }
}
