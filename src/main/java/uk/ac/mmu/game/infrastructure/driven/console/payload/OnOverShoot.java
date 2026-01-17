package uk.ac.mmu.game.infrastructure.driven.console.payload;

public class OnOverShoot {

  final public String playerColour;
  final public String playerName;

  public OnOverShoot(String playerColour, String playerName) {
    this.playerColour = playerColour;
    this.playerName = playerName;
  }
}
