package uk.ac.mmu.game.infrastructure.driven.console.payload;

public class OnRemain {

  final public String name;
  final public String startPos;

  public OnRemain(String name, String startPos) {
    this.name = name;
    this.startPos = startPos;
  }
}
