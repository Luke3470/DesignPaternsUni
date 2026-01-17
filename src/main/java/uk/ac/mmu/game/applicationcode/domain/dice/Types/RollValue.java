package uk.ac.mmu.game.applicationcode.domain.dice.Types;

import java.util.Objects;

public class RollValue {

  static final int NONE = 0;
  final private int rollValue;

  private RollValue(int rollValue) {
    if ((rollValue < 1) || (rollValue > 12)) {
      throw new IllegalArgumentException("Roll value must be between 1 and 12");
    }
    this.rollValue = rollValue;
  }

  public static RollValue of(int value) {
    return new RollValue(value);
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    RollValue rollValue1 = (RollValue) o;
    return rollValue == rollValue1.rollValue;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(rollValue);
  }

  @Override
  public String toString() {
    return String.valueOf(rollValue);
  }

  public int get() {
    return rollValue;
  }
}

