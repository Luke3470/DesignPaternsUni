package uk.ac.mmu.game.applicationcode.domain.dice;


class DoubleDiceFactory implements DiceFactory {
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
