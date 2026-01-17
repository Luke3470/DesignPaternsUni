package uk.ac.mmu.game.applicationcode.domain.player;

import uk.ac.mmu.game.applicationcode.domain.entities.Player;

public class BasicPlayerSelector implements PlayerSelector {

  private final Player[] playerList;
  private int currentPlayer;

  public BasicPlayerSelector(Player[] playerList) {
    this.playerList = playerList;
    this.currentPlayer = 0;
  }

  @Override
  public Player next() {
    int playerToReturn = currentPlayer;
    currentPlayer = (currentPlayer + 1) % (playerList.length);
    return playerList[playerToReturn];
  }
}