package uk.ac.mmu.game.applicationcode.domain.dice;

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
