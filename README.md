Frustration Game
=================
***Software Design And Architecture***

**Author:** *Luke Cadman*
# Dice Variation
```mermaid
classDiagram

    class Dice {
    <<interface>>
    ~roll() int
    }

    class DiceDecorator {
        -Dice component
        -Dice dice
        +roll() int
        +toString() String
    }

    class DiceFactory {
        <<interface>>
        ~assemble() Dice
    }


    class DoubleDiceFactory {
        -DiceFactory factory
        +Dice assemble()
        +toString() String 
    }
    
    class NonRandomDice{
        -RollValue[] rolls
        -int current
        +roll() int
        +toString() String
        +lenght() int
    }

    class SingleDice {
        -Random rand
        +roll() int
        +toString() String
    }

    class SingleDiceFactory {
        +Dice assemble()
        +toString() String 
    }
    
    DiceDecorator <|-- Dice
    DiceFactory <|.. DiceFactoryImpl
'''
---------------
Hit variation
Win variation
Player
State Machine
File Output
Solid
Ports and A
Implemntation
