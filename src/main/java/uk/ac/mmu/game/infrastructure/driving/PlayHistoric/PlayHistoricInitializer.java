package uk.ac.mmu.game.infrastructure.driving.PlayHistoric;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import uk.ac.mmu.game.applicationcode.usecase.RequiredHistoricGame;
import uk.ac.mmu.game.applicationcode.usecase.playhistoric.ProvidedPlayHistoric;
import uk.ac.mmu.game.applicationcode.usecase.playhistoric.Request;
import uk.ac.mmu.game.applicationcode.usecase.playhistoric.Response;

@Component
public class PlayHistoricInitializer implements CommandLineRunner, Ordered {

  private final RequiredHistoricGame historicGame;

  public PlayHistoricInitializer(RequiredHistoricGame historicGame) {
    this.historicGame = historicGame;
  }

  @Override
  public void run(String... args) {
    System.out.println("=== Starting Historic Game ===");
    Request req = new Request(historicGame.getDice(), historicGame.getAssetFactory(),
        historicGame.getHitCondition(), historicGame.getWinCondition());
    Response success = ProvidedPlayHistoric.handle(req).play();
    if (!success.isSuccess()) {
      System.out.println("=== Historic Game failed ===");
    }
  }

  @Override
  public int getOrder() {
    return Ordered.LOWEST_PRECEDENCE;
  }
}
