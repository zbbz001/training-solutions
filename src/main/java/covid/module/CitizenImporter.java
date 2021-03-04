package covid.module;

import covid.Citizen;
import covid.dao.CitizenDao;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CitizenImporter extends FromConsole {
    private final List<String> invalidLines = new ArrayList<>();
    private final List<Citizen> validatedCitizens = new ArrayList<>();

    public CitizenImporter(DataSource dataSource) {
        super(dataSource);
    }

    public void runModule() {
        Path file = getFileWithPathFromConsole();
        String separator = getSeparatorFromConsole();
        int numOfLineToSkip = getNumOfSkipLineFromConsole();

        readAndValidateData(file, separator, numOfLineToSkip);

        new CitizenDao(dataSource).saveMultipleCitizens(validatedCitizens);

        showImportResult();
    }

    private void showImportResult() {
        StringBuilder result = new StringBuilder();
        result.append("Sikeresen importált sorok száma: ");
        result.append(validatedCitizens.size());
        result.append("\n");
        result.append("Hibás sorok száma: ");
        result.append(invalidLines.size());
        result.append("\n");

        for (String line : invalidLines) {
            result.append(line);
            result.append("\n");
        }

        writeToConsoleLn(result::toString);
    }


    private void readAndValidateData(Path file, String separator, int numOfLineToSkip) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            int lineNum = 0;
            for (int i = 0; i < numOfLineToSkip; i++) {
                reader.readLine();
                lineNum++;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                lineNum++;
                validateData(line, lineNum, separator);
            }
        } catch (IOException e) {
            writeToConsoleLn(() -> "Hiba a fájl beolvasásakor!\n");
        }
    }

    private void validateData(String line, int lineNum, String separator) {
        if (citizenValidator.validateFromLine(separator, line)) {
            validatedCitizens.add(citizenValidator.makeCitizen());
        } else {
            String message = citizenValidator.getMessage()
                    .replace("{line}", String.valueOf(lineNum));

            invalidLines.add(message + " " + line);
        }
    }
}
