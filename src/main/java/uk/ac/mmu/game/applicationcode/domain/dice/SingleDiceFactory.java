package uk.ac.mmu.game.applicationcode.domain.dice;

import uk.ac.mmu.game.domain.dice.Dice;
import uk.ac.mmu.game.domain.dice.DiceFactory;
import uk.ac.mmu.game.domain.dice.SingleDice;

public class SingleDiceFactory implements DiceFactory {
    @Override
    public Dice assemble(){
        return new SingleDice();
    }
    @Override
    public String toString(){
        return "Single Dice";
    }
}
