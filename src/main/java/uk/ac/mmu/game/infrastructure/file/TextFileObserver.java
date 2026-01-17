package uk.ac.mmu.game.infrastructure.file;

import uk.ac.mmu.game.applicationcode.domain.dice.Types.RollValue;
import uk.ac.mmu.game.applicationcode.domain.observers.FileObserver;
import uk.ac.mmu.game.infrastructure.file.payload.CreateFile;

import java.io.FileWriter;
import java.io.IOException;

public class TextFileObserver implements FileObserver {
    private final String savePath;

    public TextFileObserver(String savePath) {
        this.savePath = savePath;
    }

    @Override
    public void onEvent(CreateFile payload) {
        try (FileWriter writer = new FileWriter(savePath+java.util.UUID.randomUUID())) {

            writer.write("HitCondition: " + payload.hitCondition.toString() + "\n");

            writer.write("WinCondition: " + payload.winCondition.toString() + "\n");

            writer.write("Asset: "+ payload.assets.toString() + "\n");
            for (RollValue roll : payload.rolls) {
                writer.write(roll.toString() + "\n");
            }

            System.out.println("Saved game to " + savePath);

        } catch (IOException e) {
            System.err.println("Failed to save game: " + e.getMessage());
        }
    }
}
