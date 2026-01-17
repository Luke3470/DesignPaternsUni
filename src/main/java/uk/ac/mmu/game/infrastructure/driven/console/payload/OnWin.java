package uk.ac.mmu.game.infrastructure.driven.console.payload;

import uk.ac.mmu.game.applicationcode.domain.entities.Player;

public class OnWin {

  final public Player player;
  final public int turn;
  final public int totalTurns;

  public OnWin(Player player, int turn, int totalTurns) {
    this.player = player;
    this.turn = turn;
    this.totalTurns = totalTurns;
  }
}
