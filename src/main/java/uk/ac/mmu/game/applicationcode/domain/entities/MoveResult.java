package uk.ac.mmu.game.applicationcode.domain.entities;

public class MoveResult {
    public final Player player;
    public final String from;
    public final String to;
    private final Command command;

    public MoveResult(Player player, String from, String to, Command command) {
        this.player = player;
        this.from = from;
        this.to = to;
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
