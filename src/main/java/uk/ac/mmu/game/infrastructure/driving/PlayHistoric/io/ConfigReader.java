package uk.ac.mmu.game.infrastructure.driving.PlayHistoric.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigReader {

    public static GameConfig load(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String hitLine = reader.readLine();
            String winLine = reader.readLine();
            String assetLine = reader.readLine();

            String hitValue = getValue(hitLine);
            String winValue = getValue(winLine);
            String assetValue = getValue(assetLine);

            List<Integer> numbers = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    numbers.add(Integer.parseInt(line.trim()));
                }
            }

            return new GameConfig(hitValue, winValue, assetValue, numbers);
        }catch (IOException e) {
            System.err.println("Failed to save game: " + e.getMessage());
            return null;
        }
    }

    static String getValue(String line) {
        if (line == null) return null;
        String[] parts = line.split(":", 2);
        return parts.length == 2 ? parts[1].trim() : null;
    }
}
