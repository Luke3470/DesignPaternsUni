package uk.ac.mmu.game.infrastructure.console.payload;

public class OnOverShoot {
    public String playerColour;
    public String playerName;

    public OnOverShoot(String playerColour, String playerName) {
        this.playerColour = playerColour;
        this.playerName = playerName;
    }
}
