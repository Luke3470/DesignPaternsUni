package uk.ac.mmu.game.applicationcode.domain.board;

public interface Board {
    void move(Player player,int diceRoll);
    String getPos(Player player);
    void setPos(Player player,String pos);
    int getLastRemainingRoll();
    int findPlayerOnInnerBoards(Player player);
    int tailLength();
    String posContains(String pos,Player currentPlayer);
    String getEndPos(Player player);
}
