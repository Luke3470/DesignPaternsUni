package uk.ac.mmu.game.applicationcode.domain.dice;

import uk.ac.mmu.game.domain.dice.Dice;
import uk.ac.mmu.game.domain.dice.SingleDice;

public class DiceDecorator  implements uk.ac.mmu.game.domain.dice.Dice {
    private final uk.ac.mmu.game.domain.dice.Dice component;
    private final uk.ac.mmu.game.domain.dice.Dice dice = new SingleDice();

    public DiceDecorator(Dice component){
        this.component = component;
    }

    @Override
    public int roll() {
       return dice.roll() + component.roll();
    }

    @Override
    public String toString(){
        return "DoubleDice";
    }
}
