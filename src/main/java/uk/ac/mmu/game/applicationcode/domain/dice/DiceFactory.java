package uk.ac.mmu.game.applicationcode.domain.dice;

import uk.ac.mmu.game.domain.dice.Dice;

public interface DiceFactory {
    Dice assemble();
}
