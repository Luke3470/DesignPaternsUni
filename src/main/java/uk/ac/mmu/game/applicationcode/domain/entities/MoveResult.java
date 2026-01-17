package uk.ac.mmu.game.applicationcode.domain.entities;

import uk.ac.mmu.game.domain.entities.Command;
import uk.ac.mmu.game.domain.entities.Player;

public class MoveResult {
    public final uk.ac.mmu.game.domain.entities.Player player;
    public final String from;
    public final String to;
    private final uk.ac.mmu.game.domain.entities.Command command;

    public MoveResult(Player player, String from, String to, uk.ac.mmu.game.domain.entities.Command command) {
        this.player = player;
        this.from = from;
        this.to = to;
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
