package uk.ac.mmu.game.applicationcode.usecase.play;

import uk.ac.mmu.game.applicationcode.domain.Game;
import uk.ac.mmu.game.applicationcode.usecase.RequiredAssetFactory;
import uk.ac.mmu.game.applicationcode.usecase.RequiredDice;
import uk.ac.mmu.game.applicationcode.usecase.RequiredHitCondition;
import uk.ac.mmu.game.applicationcode.usecase.RequiredWinCondition;

public class PlayGameUseCase implements ProvidedPlayGame {

  private final RequiredDice dice;
  private final RequiredAssetFactory assets;
  private final RequiredHitCondition hitCondition;
  private final RequiredWinCondition winCondition;

  public PlayGameUseCase(
      RequiredDice dice,
      RequiredAssetFactory assets,
      RequiredHitCondition hitCondition,
      RequiredWinCondition winCondition
  ) {
    this.dice = dice;
    this.assets = assets;
    this.hitCondition = hitCondition;
    this.winCondition = winCondition;
  }

  @Override
  public void play() {
    Game game = new Game(
        dice.getDice(),
        assets.getAssetFactory(),
        hitCondition.getHitCondition(),
        winCondition.getWinCondition()
    );
    game.play();
  }
}