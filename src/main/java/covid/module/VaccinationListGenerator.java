package covid.module;

import covid.Zip;
import covid.dao.VaccinationsDao;

import javax.sql.DataSource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

public class VaccinationListGenerator extends FromConsole {
    private boolean overwriteAble = true;
    private static final int MAX_NUM_OF_PATIENT = 16;
    private static final String SEPARATOR = ";";
    private static final int APPOINTMENT_START_HOUR = 8;
    private static final int APPOINTMENT_START_MINUTES = 0;
    private static final int APPOINTMENT_INTERVAL = 30;

    private Zip zip;

    public VaccinationListGenerator(DataSource dataSource) {
        super(dataSource);
    }

    public void runModule() {
        String filenameWithPath = setFilenameWithPathFromConsole();
        zip = getZipFromConsole();

        List<HashMap<String, Object>> collectedData = new VaccinationsDao(dataSource).selectDataToVaccinationList(zip, MAX_NUM_OF_PATIENT);

        if (collectedData.isEmpty()) {
            writeToConsoleLn(() -> "A megadott településen, nincs beoltandó!");
            return;
        }

        writeToFile(filenameWithPath, collectedData);
        writeToConsoleLn(() -> "A vakcinációs lista elkészült!\n");
    }

    private String setFilenameWithPathFromConsole() {
        String inputString;

        while (true) {
            writeToConsole(() -> "Vakcinációs jegyzék (elérési úttal): ");
            inputString = scanner.nextLine();

            if (checkFileExists(inputString)) {
                if (!overwriteAble) {
                    return generateFilename(inputString);
                }

                return inputString;
            }
        }
    }

    private void writeToFile(String filenameWithPath, List<HashMap<String, Object>> collectedData) {
        File file = new File(filenameWithPath);
        file.getParentFile().mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Időpont" + SEPARATOR +
                    "Név" + SEPARATOR +
                    "Irányítószám" + SEPARATOR +
                    "Életkor" + SEPARATOR +
                    "E-mail cím" + SEPARATOR +
                    "TAJ szám");
            writer.newLine();

            LocalTime localTime = LocalTime.of(APPOINTMENT_START_HOUR, APPOINTMENT_START_MINUTES);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            for (HashMap<String, Object> dataRow : collectedData) {
                writer.write(generateLine(dataRow, localTime.format(formatter)));
                writer.newLine();
                localTime = localTime.plusMinutes(APPOINTMENT_INTERVAL);
            }
        } catch (IOException e) {
            writeToConsoleLn(() -> "A fájl írásakor, hiba történt! " + e.getMessage());
        }
    }

    private String generateLine(HashMap<String, Object> dataRow, String time) {
        return time + SEPARATOR +
                dataRow.get("citizen_name").toString() + SEPARATOR +
                zip.getZip_code() + SEPARATOR +
                dataRow.get("age").toString() + SEPARATOR +
                dataRow.get("email").toString() + SEPARATOR +
                dataRow.get("ssn").toString();
    }

    private String generateFilename(String str) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        int index = str.lastIndexOf(".");

        if (index == -1) {
            return str + "_" + dateTime;
        } else {
            String filename = str.substring(0, index);
            String extension = str.substring(index);

            return filename + "_" + dateTime + extension;
        }
    }

    private boolean checkFileExists(String inputPath) {
        try {
            Path path = Path.of(inputPath);

            if (Files.isDirectory(path)) {
                throw new InvalidPathException(inputPath, "Hibás fájlnév, könyvtár adott meg!");
            }

            if (Files.isWritable(path)) {
                fileCanBeOverwritten();
            }
        } catch (InvalidPathException ipe) {
            writeToConsoleLn(() -> "Hibás elérési útvonal: " + ipe.getMessage());
            return false;
        }

        return true;
    }

    private void fileCanBeOverwritten() {
        List<String> options = List.of("I", "N");

        while (true) {
            writeToConsole(() -> "A fájl létezik, felülírja? (I/N) ");
            String inputString = scanner.nextLine().toUpperCase();

            if (inputString.length() != 1 || !options.contains(inputString)) {
                writeToConsoleLn(() -> "Hibás válasz, ismételje meg!");
            } else {
                if (inputString.equals("N")) {
                    overwriteAble = false;
                }

                return;
            }
        }
    }
}
