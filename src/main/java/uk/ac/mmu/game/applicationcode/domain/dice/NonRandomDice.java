package uk.ac.mmu.game.applicationcode.domain.dice;

import uk.ac.mmu.game.domain.dice.Dice;
import uk.ac.mmu.game.domain.dice.Types.RollValue;

public class NonRandomDice implements Dice {
    private RollValue[] rolls;
    private int current = 0;

    public NonRandomDice(int[] newRolls) {
        this.rolls = new RollValue[newRolls.length];
        for (int i = 0; i < newRolls.length; i++) {
            this.rolls[i] = RollValue.of(newRolls[i]);
        }
    }

    @Override
    public int roll() {
        if (current >= rolls.length) {
            throw new IndexOutOfBoundsException("Predefined Dice Rolls exhausted");
        }
        return rolls[current++].get();
    }
    @Override
    public String toString(){
        return "NonRandomDice";
    }
}