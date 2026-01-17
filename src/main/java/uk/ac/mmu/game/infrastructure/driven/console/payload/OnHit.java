package uk.ac.mmu.game.infrastructure.driven.console.payload;

public class OnHit {

  final public String TextColour;
  final public String playerHit;
  final public String pos;

  public OnHit(String TextColour, String playerHit, String pos) {
    this.TextColour = TextColour;
    this.playerHit = playerHit;
    this.pos = pos;
  }
}
