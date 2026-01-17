package uk.ac.mmu.game.applicationcode.domain.rules;

import uk.ac.mmu.game.domain.entities.MoveResult;
import uk.ac.mmu.game.domain.entities.Player;
import uk.ac.mmu.game.domain.rules.Outcomes.MoveOutcome;
import uk.ac.mmu.game.domain.rules.Outcomes.NormalOutcome;
import uk.ac.mmu.game.domain.rules.Outcomes.OverShootOutcome;
import uk.ac.mmu.game.domain.rules.Outcomes.WinOutcome;
import uk.ac.mmu.game.domain.rules.WinCondition;


public class WinConditionExact implements WinCondition {
    @Override
    public MoveOutcome checkWin(Board board, MoveResult move) {
        Player player = move.player;

        int tailPos = board.findPlayerOnInnerBoards(player);
        int tailEnd = board.tailLength() - 1;

        if (tailPos == -1 || tailPos < tailEnd) {
            return new NormalOutcome();
        }

        if (tailPos == tailEnd && board.getLastRemainingRoll() == 0) {
            return new WinOutcome();
        }

        return new OverShootOutcome();
    }
    @Override
    public String toString(){
        return "WinConditionExact";
    }
}
