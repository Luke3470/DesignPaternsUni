package uk.ac.mmu.game.applicationcode.domain.dice;


import java.util.Random;

class SingleDice implements Dice {
    private final Random rand = new Random();
    @Override
    public int roll() {
        return rand.nextInt(6) + 1;
    }
    @Override
    public String toString(){
        return "SingleDice";
    }
}
