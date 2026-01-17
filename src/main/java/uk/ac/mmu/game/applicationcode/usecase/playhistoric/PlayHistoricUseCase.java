package uk.ac.mmu.game.applicationcode.usecase.playhistoric;

import uk.ac.mmu.game.applicationcode.domain.Game;
import uk.ac.mmu.game.applicationcode.domain.dice.Dice;
import uk.ac.mmu.game.applicationcode.domain.factories.AssetFactory;
import uk.ac.mmu.game.applicationcode.domain.rules.HitCondition;
import uk.ac.mmu.game.applicationcode.domain.rules.WinCondition;

public class PlayHistoricUseCase implements ProvidedPlayHistoric {

  private final Dice dice;
  private final AssetFactory assets;
  private final HitCondition hitCondition;
  private final WinCondition winCondition;

  public PlayHistoricUseCase(Request request) {
    this.dice = request.getDice();
    this.assets = request.getAssetFactory();
    this.hitCondition = request.getHitCondition();
    this.winCondition = request.getWinCondition();
  }

  @Override
  public Response play() {
    Game game = new Game(
        dice,
        assets,
        hitCondition,
        winCondition
    );
    game.play();
    return new Response(true);
  }
}
