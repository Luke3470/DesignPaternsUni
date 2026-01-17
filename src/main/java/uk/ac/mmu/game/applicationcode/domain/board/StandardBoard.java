package uk.ac.mmu.game.applicationcode.domain.board;

import java.util.HashSet;
import java.util.Set;
import uk.ac.mmu.game.applicationcode.domain.entities.Player;

public class StandardBoard implements Board {

  private final Set<String>[] outerBoard;
  private final String[][] innerBoards;
  private int lastRemainingRoll = 0;

  public StandardBoard(int outerSize, int tailLength, Player[] players) {
    outerBoard = new HashSet[outerSize];
    for (int i = 0; i < outerSize; i++) {
      outerBoard[i] = new HashSet<>();
    }

    innerBoards = new String[players.length][tailLength];

    for (Player p : players) {
      outerBoard[p.getStartPos()].add(p.getName());
    }
  }

  @Override
  public void move(Player player, int diceRoll) {
    int outerPos = findPlayerOnOuterBoard(player);
    int tailPos = findPlayerOnTail(player);
    int boardSize = outerBoard.length;

    if (outerPos != -1) {
      int distanceToFinal = (player.getFinalTrackPos() - outerPos + boardSize) % boardSize;

      if (diceRoll <= distanceToFinal) {
        outerBoard[(outerPos) % boardSize].remove(player.getName());
        outerBoard[(outerPos + diceRoll) % boardSize].add(player.getName());
        lastRemainingRoll = 0;
      } else {
        outerBoard[outerPos].remove(player.getName());

        int tailIndex = diceRoll - distanceToFinal - 1;
        if (tailIndex >= tailLength()) {
          tailIndex = tailLength() - 1;
        }

        innerBoards[player.getIndex()][tailIndex] = player.getName();

        lastRemainingRoll = diceRoll - distanceToFinal - (tailIndex + 1);
        if (lastRemainingRoll < 0) {
          lastRemainingRoll = 0;
        }
      }

    } else if (tailPos != -1) {
      innerBoards[player.getIndex()][tailPos] = null;

      int newTailPos = tailPos + diceRoll;
      if (newTailPos >= tailLength()) {
        newTailPos = tailLength() - 1;
      }

      innerBoards[player.getIndex()][newTailPos] = player.getName();

      lastRemainingRoll = diceRoll - (newTailPos - tailPos);
      if (lastRemainingRoll < 0) {
        lastRemainingRoll = 0;
      }
    }
  }


  private int findPlayerOnOuterBoard(Player player) {
    for (int i = 0; i < outerBoard.length; i++) {
      if (outerBoard[i].contains(player.getName())) {
        return i;
      }
    }
    return -1;
  }

  private int findPlayerOnTail(Player player) {
    for (int i = 0; i < innerBoards[player.getIndex()].length; i++) {
      if (player.getName().equals(innerBoards[player.getIndex()][i])) {
        return i;
      }
    }
    return -1;
  }


  @Override
  public String getPos(Player player) {
    int tailPos = findPlayerOnTail(player);
    if (tailPos != -1) {
      return player.getName().charAt(0) + String.valueOf(tailPos + 1);
    }

    int outerPos = findPlayerOnOuterBoard(player);
    if (outerPos != -1) {
      return String.valueOf(outerPos + 1);
    }

    return "Home";
  }

  @Override
  public void setPos(Player player, String pos) {
    int outer = findPlayerOnOuterBoard(player);
    if (outer != -1) {
      outerBoard[outer].remove(player.getName());
    }

    int tail = findPlayerOnTail(player);
    if (tail != -1) {
      innerBoards[player.getIndex()][tail] = null;
    }

    String numeric = pos.replaceAll("[^0-9]", "");
    if (numeric.isEmpty()) {
      return;
    }

    int index = Integer.parseInt(numeric) - 1;

    if (pos.startsWith(player.getName().charAt(0) + "")) {
      innerBoards[player.getIndex()][index] = player.getName();
    } else {
      outerBoard[index].add(player.getName());
    }
  }

  @Override
  public String posContains(String pos, Player currentPlayer) {
    String numeric = pos.replaceAll("[^0-9]", "");
    if (numeric.isEmpty()) {
      return null;
    }

    int index = Integer.parseInt(numeric) - 1;
    Set<String> occupants = outerBoard[index];

    if (occupants.isEmpty()) {
      return null;
    }

    StringBuilder sb = new StringBuilder();
    for (String name : occupants) {
      if (!name.equals(currentPlayer.getName())) {
        if (!sb.isEmpty()) {
          sb.append(", ");
        }
        sb.append(name);
      }
    }

    return sb.isEmpty() ? null : sb.toString();
  }

  @Override
  public int findPlayerOnInnerBoards(Player player) {
    return findPlayerOnTail(player);
  }

  @Override
  public int tailLength() {
    return innerBoards[0].length;
  }

  @Override
  public int getLastRemainingRoll() {
    return lastRemainingRoll;
  }

  @Override
  public String getEndPos(Player player) {
    return player.getName().charAt(0) + String.valueOf(tailLength());
  }
}
