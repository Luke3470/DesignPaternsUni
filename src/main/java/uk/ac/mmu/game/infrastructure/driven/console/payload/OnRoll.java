package uk.ac.mmu.game.infrastructure.driven.console.payload;

import uk.ac.mmu.game.applicationcode.domain.entities.Player;

public class OnRoll {

  final public Player player;
  final public int roll;
  final public int turn;

  public OnRoll(Player player, int roll, int turn) {
    this.player = player;
    this.roll = roll;
    this.turn = turn;
  }
}
