package uk.ac.mmu.game.applicationcode.domain;

import Game.Assets.*;
import Game.Dice.Dice;
import Game.Dice.Types.RollValue;
import Game.Rules.HitCondition;
import Game.Rules.WinCondition;
import Game.States.GameState;
import Game.States.GameStateGameOver;
import Game.States.GameStateReady;
import uk.ac.mmu.game.infrastructure.console.payload.Initialization;
import uk.ac.mmu.game.infrastructure.file.payload.CreateFile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class Game {
    private GameState gameState = new GameStateReady(this);
    private final Dice dice;
    private final PlayerIterable playersList;
    private final Board board;
    private final HitCondition hitCondition;
    private final WinCondition winCondition;
    private final List<BaseObserver> observers = new ArrayList<>();
    private final AssetFactory assets;
    private final List<RollValue> rolls = new ArrayList<>();

    public Game(Dice dice, AssetFactory assetFactory, HitCondition hitCondition, WinCondition winCondition) {
        this.dice = dice;
        this.assets = assetFactory;
        this.playersList = assetFactory.createPlayers();
        this.board = assetFactory.createBoard();
        this.hitCondition = hitCondition;
        this.winCondition = winCondition;
        this.playersList.setGame(this);
        addDefaultObservers();
        initialize();
    }

    public void clearObservers() {
        observers.clear();
    }
    public <T extends BaseObserver> void notifyObservers(Class<T> type, Consumer<T> action) {
        observers.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .forEach(action);
    }

    public void initialize(){
        Initialization init = new Initialization(this.hitCondition,this.winCondition,this.assets,this.dice);
        notifyObservers(PlayObserver.class,PlayObserver -> PlayObserver.onEvent(init));
    }

    public void setState(GameState state) {
        this.gameState = state;
    }

    public void addRoll(RollValue roll) {
        rolls.add(roll);
    }

    public void addDefaultObservers() {
        observers.add(new ConsolePlayObserver());
        observers.add(new TextFileObserver((System.getProperty("user.dir") +"\\Games\\" )));
        observers.add(new ConsoleStateObserver());
    }

    public GameState getState(){return this.gameState;}

    public void play() {
        this.gameState.show();
        while(!(this.gameState instanceof GameStateGameOver)){
            gameState.play();
        }
        gameState.play();
        clearObservers();
    }

    public PlayerIterable getPlayersList() {
        return playersList;
    }

    public Dice getDice() {
        return dice;
    }

    public Board getBoard() {
        return board;
    }

    public HitCondition getHitCondition() {
        return hitCondition;
    }

    public WinCondition getWinCondition() {
        return winCondition;
    }
    public CreateFile save(){
        return new CreateFile(hitCondition,winCondition,rolls,assets);
    }
}
