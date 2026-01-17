package uk.ac.mmu.game.applicationcode.usecase.play;

public interface Provided {
    void play();

    static Provided getInstance(Required required) {
        return new PlayGameUseCase(required);
    }
}
