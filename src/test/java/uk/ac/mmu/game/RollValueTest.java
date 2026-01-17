package uk.ac.mmu.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.mmu.game.applicationcode.domain.dice.Types.RollValue;

@SpringBootTest
class RollValueTest {

  @Nested
  @DisplayName("Creation tests")
  class CreationTests {

    @Test
    @DisplayName("Should create RollValue for valid range 1-12")
    void testValidRollValueCreation() {
      for (int i = 1; i <= 12; i++) {
        RollValue roll = RollValue.of(i);
        assertThat(roll.get()).isEqualTo(i);
        assertThat(roll.toString()).isEqualTo(String.valueOf(i));
      }
    }

    @Test
    @DisplayName("Should throw exception for value below 1")
    void testRollValueBelowRange() {
      assertThatThrownBy(() -> RollValue.of(0))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessage("Roll value must be between 1 and 12");
    }

    @Test
    @DisplayName("Should throw exception for value above 12")
    void testRollValueAboveRange() {
      assertThatThrownBy(() -> RollValue.of(13))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessage("Roll value must be between 1 and 12");
    }
  }

  @Nested
  @DisplayName("Equality and Hashcode tests")
  class EqualityTests {

    @Test
    @DisplayName("RollValues with same value should be equal")
    void testEqualRollValues() {
      RollValue a = RollValue.of(5);
      RollValue b = RollValue.of(5);

      assertThat(a).isEqualTo(b);
      assertThat(a.hashCode()).isEqualTo(b.hashCode());
    }

    @Test
    @DisplayName("RollValues with different values should not be equal")
    void testDifferentRollValues() {
      RollValue a = RollValue.of(3);
      RollValue b = RollValue.of(4);

      assertThat(a).isNotEqualTo(b);
      assertThat(a.hashCode()).isNotEqualTo(b.hashCode());
    }

    @Test
    @DisplayName("RollValue should not equal null or different class")
    void testEqualityWithOtherObjects() {
      RollValue a = RollValue.of(6);
      assertThat(a).isNotEqualTo(null);
      assertThat(a).isNotEqualTo("6");
    }
  }

  @Nested
  @DisplayName("Accessor tests")
  class AccessorTests {

    @Test
    @DisplayName("get() should return underlying value")
    void testGetValue() {
      RollValue roll = RollValue.of(7);
      assertThat(roll.get()).isEqualTo(7);
    }

    @Test
    @DisplayName("toString() should return string representation of value")
    void testToString() {
      RollValue roll = RollValue.of(10);
      assertThat(roll.toString()).isEqualTo("10");
    }
  }
}
