package uk.ac.mmu.game.infrastructure.driven.console.payload;

public class OnHit {
    public String TextColour;
    public String playerHit;
    public String pos;

    public OnHit(String TextColour, String playerHit, String pos) {
        this.TextColour = TextColour;
        this.playerHit = playerHit;
        this.pos = pos;
    }
}
