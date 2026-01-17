package uk.ac.mmu.game.applicationcode.domain.observers;


import uk.ac.mmu.game.infrastructure.driven.file.payload.CreateFile;

public interface FileObserver extends BaseObserver {
    void onEvent(CreateFile Payload);
}
