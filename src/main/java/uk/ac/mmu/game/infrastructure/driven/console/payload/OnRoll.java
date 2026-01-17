package uk.ac.mmu.game.infrastructure.driven.console.payload;

import uk.ac.mmu.game.applicationcode.domain.entities.Player;

public class OnRoll {
    public Player player;
    public int roll;

    public OnRoll(Player player, int roll) {
        this.player = player;
        this.roll = roll;
    }
}
