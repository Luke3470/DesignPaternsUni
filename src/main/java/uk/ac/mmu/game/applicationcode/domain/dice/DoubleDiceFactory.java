package uk.ac.mmu.game.applicationcode.domain.dice;

import uk.ac.mmu.game.domain.dice.Dice;
import uk.ac.mmu.game.domain.dice.DiceDecorator;
import uk.ac.mmu.game.domain.dice.DiceFactory;
import uk.ac.mmu.game.domain.dice.SingleDiceFactory;

public class DoubleDiceFactory implements uk.ac.mmu.game.domain.dice.DiceFactory {
    private final DiceFactory factory = new SingleDiceFactory();

    @Override
    public Dice assemble() {
        return new DiceDecorator(factory.assemble());
    }
    @Override
    public String toString(){
        return "DoubleDice";
    }
}
