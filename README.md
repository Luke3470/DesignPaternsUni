Frustration Game
=================
***Software Design And Architecture***

**Author:** *Luke Cadman*

I am Going to Caveat this by stating i am NOT going to be doing complete UML diagrams for any OOP 
principles. Other than Inheritance and others in certain cases because otherwise it becomes ugly and the UML diagrams start to 
mean less; just become a mess of lines and are harder to interpret.

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
talk about use of move outcome to simplfy response put in sample

---------------
# Win Variation
```mermaid
classDiagram

    class WinCondition {
        <<interface>>
        ~checkWin(Board, MoveResult) MoveOutcome
    }
    
    class WinConditionOnePerSpace {
        +checkHit(Board, MoveResult) MoveOutcome
        +toString() String
    }
    
    class WinConditionStandard {
        +checkHit(Board, MoveResult) MoveOutcome
        +toString() String
    }
    
    WinCondition <|-- WinConditionStandard
    WinCondition <|-- WinConditionOnePerSpace
```
How Similar Designed to Above class just with different outcome
and show how commands are used in outcome to deal with resets
and how use of tostring overrides allows for simple file and console output

---------------
# 4 Player Variation
```mermaid
classDiagram

    class AssetFactory {
        <<interface>>
        +createPlayers() PlayerIterable
        +createBoard() createBoard
    }
    
    class PlayerFactory{
        <<interface>>
        +construct() Player[]    
    }
    
    class PlayerSelector{
        <<interface>>
        +next() Player
    }
    
    class BasicPlayerSelector{
        -Player[] playerList
        -int currentPlayer
        +next() Player
    }
    class PlayerIterator{
        +iterator PlayerIterator
    }
        
    class TwoPlayerAssets{
        +createPlayers() PlayerIterable
        +createBoard() createBoard
        +toString() String
    }
    
    class FourPlayerAssets{
        +createPlayers() PlayerIterable
        +createBoard() createBoard
        +toString() String
    }
    
    class TwoPlayerFactory{
        +construct() Player[]    
    }
    
    class FourPlayerFactory{
        +construct() Player[]    
    }
    class TwoPlayerBoardFactory{
        +create() Player[]    
    }
    class FourPlayerBoardFactory{
        +create() Player[]    
    }
        
    PlayerSelector <|-- BasicPlayerSelector
    WinCondition <|-- WinConditionOnePerSpace
```
Trying to find somewhere to put an abstract factory as these depedned on each other worked well
Use of iterator as well in main game loop to allow for cleaner rotation of player which is more expandabkle in future SRP
---------------
State Machine
File Output
Solid
Ports and A
Implemntation
