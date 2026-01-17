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
    
    Dice <|-- DiceDecorator
    Dice <|-- NonRandomDice
    Dice <|-- SingleDice
    DiceFactory <|-- SingleDiceFactory
    DiceFactory <|-- DoubleDiceFactory
```
Dice Variations talk about value object and null pattern

---------------
# Hit Variation
```mermaid
classDiagram

    class HitCondition {
        <<interface>>
        ~checkHit(Board, MoveResult) MoveOutcome
    }
    
    class HitConditionOnePerSpace {
        +checkHit(Board, MoveResult) MoveOutcome
        +toString() String
    }
    
    class HitConditionStandard {
        +checkHit(Board, MoveResult) MoveOutcome
        +toString() String
    }
    
    HitCondition <|-- HitConditionStandard
    HitCondition <|-- HitConditionOnePerSpace
```
---------------
Win variation
Player
State Machine
File Output
Solid
Ports and A
Implemntation
