package uk.ac.mmu.game.applicationcode.domain.dice;


public class DiceDecorator  implements Dice {
    private final Dice component;
    private final Dice dice = new SingleDice();

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
