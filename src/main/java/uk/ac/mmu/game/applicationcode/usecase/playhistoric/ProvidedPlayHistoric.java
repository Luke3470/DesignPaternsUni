package uk.ac.mmu.game.applicationcode.usecase.playhistoric;

public interface ProvidedPlayHistoric {

  Response play();

  static ProvidedPlayHistoric handle(Request request) {
    return new PlayHistoricUseCase(request);
  }
}