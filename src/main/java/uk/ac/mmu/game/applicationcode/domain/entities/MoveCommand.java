package uk.ac.mmu.game.applicationcode.domain.entities;


import uk.ac.mmu.game.applicationcode.domain.board.Board;

public class MoveCommand implements Command {

  private final Player player;
  private final Board board;
  private final int roll;

  private String startPos;

  public MoveCommand(Player player, Board board, int roll) {
    this.player = player;
    this.board = board;
    this.roll = roll;
  }

  @Override
  public MoveResult execute() {
    startPos = board.getPos(player);
    board.move(player, roll);
    String endPos = board.getPos(player);
    String fromReadable = formatPosition(startPos, true);
    String toReadable = formatPosition(endPos, false);

    return new MoveResult(player, fromReadable, toReadable, this);
  }

  @Override
  public void undo() {
    board.setPos(player, startPos);
  }

  private String formatPosition(String pos, boolean isFrom) {
    if (pos.equalsIgnoreCase("Home") || pos.equals("1") || pos.equals("10")) {
      if (isFrom) {
        return "Home (Position " + pos + ")";
      } else {
        return "Position " + pos;
      }
    }

    if (pos.startsWith("R") || pos.startsWith("B") || pos.startsWith("Y") || pos.startsWith("G")) {
      if (isFrom) {
        return "Position " + pos;
      } else {
        if (pos.equals(board.getEndPos(player))) {
          return "End (Position " + pos + ")";
        } else {
          return "Tail Position " + pos;
        }
      }
    }

    return "Position " + pos;
  }
}
