package uk.ac.mmu.game.infrastructure.driven.io;

import uk.ac.mmu.game.applicationcode.domain.config.GameConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ConfigReader {

    public GameConfig load(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            // Read first 3 lines as key/value pairs
            String hitLine = reader.readLine();
            String winLine = reader.readLine();
            String assetLine = reader.readLine();

            String hitValue = getValue(hitLine);
            String winValue = getValue(winLine);
            String assetValue = getValue(assetLine);

            // Read remaining integers
            List<Integer> numbers = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    numbers.add(Integer.parseInt(line.trim()));
                }
            }

            return new GameConfig(hitValue, winValue, assetValue, numbers);
        }
    }

    // Helper to split "Key: Value"
    private String getValue(String line) {
        if (line == null) return null;
        String[] parts = line.split(":", 2);
        return parts.length == 2 ? parts[1].trim() : null;
    }
}
