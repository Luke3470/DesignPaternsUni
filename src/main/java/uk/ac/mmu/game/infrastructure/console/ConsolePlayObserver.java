package uk.ac.mmu.game.infrastructure.console;

import uk.ac.mmu.game.applicationcode.domain.observers.PlayObserver;
import uk.ac.mmu.game.infrastructure.console.payload.*;

public class ConsolePlayObserver implements PlayObserver {
    @Override
    public void onEvent(OnRoll roll) {
        System.out.println(roll.player.getTextColour() + roll.player.getName() + " rolls " + roll.roll);
    }

    @Override
    public void onEvent(OnMove move) {
        System.out.println(move.result.player.getTextColour() + move.result.player.getName() + " moves from " + move.result.from +
                " to " + move.result.to);
    }

    @Override
    public void onEvent(OnHit hit) {
        System.out.println(hit.TextColour + hit.playerHit + " " + hit.pos + " is HIT!");
    }

    @Override
    public void onEvent(OnOverShoot overshoot) {
        System.out.println(overshoot.playerColour + overshoot.playerName + " overshoots!");
    }

    @Override
    public void onEvent(Initialization init) {
        System.out.println("HitCondition: " + init.hitCondition.toString());
        System.out.println("WinCondition: " + init.winCondition.toString());
        System.out.println("Dice: " + init.dice.toString());
        System.out.println("Players: " + init.assetFactory.toString());
    }

    @Override
    public void onEvent(OnWin win) {
        System.out.println(win.player.getTextColour() + win.player.getName() + " wins in " + win.turn + " turns!");
        System.out.println("\u001B[0m"+"Total Turns "+ win.totalTurns);
    }
}
