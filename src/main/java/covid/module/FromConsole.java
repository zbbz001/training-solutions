package covid.module;

import covid.Vaccine;
import covid.Zip;
import covid.module.toConsole.ConsoleWriter;
import covid.validator.CitizenValidator;
import covid.validator.ZipValidator;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FromConsole {
    protected final DataSource dataSource;
    protected final CitizenValidator citizenValidator;
    protected final ZipValidator zipValidator;
    protected final Scanner scanner = new Scanner(System.in);

    public FromConsole(DataSource dataSource) {
        this.dataSource = dataSource;
        this.citizenValidator = new CitizenValidator(dataSource);
        this.zipValidator = new ZipValidator(dataSource);
    }

    protected void writeToConsoleLn(ConsoleWriter writer) {
        System.out.println(writer.write());
    }

    protected void writeToConsole(ConsoleWriter writer) {
        System.out.print(writer.write());
    }

    String getCitizenNameFromConsole() {
        String inputString;

        while (true) {
            writeToConsole(() -> "Név: ");
            inputString = scanner.nextLine();

            if (!citizenValidator.isValidName(inputString)) {
                writeToConsoleLn(citizenValidator::getMessage);
            } else {
                return citizenValidator.getName();
            }
        }
    }

    int getAgeFromConsole() {
        String inputString;

        while (true) {
            writeToConsole(() -> "Életkor: ");
            inputString = scanner.nextLine();

            if (!citizenValidator.isValidAge(inputString)) {
                writeToConsoleLn(citizenValidator::getMessage);
            } else {
                return citizenValidator.getAge();
            }
        }
    }

    String getSsnFromConsole() {
        String inputString;

        while (true) {
            writeToConsole(() -> "TAJ szám: ");
            inputString = scanner.nextLine();

            if (!citizenValidator.isValidSsn(inputString)) {
                writeToConsoleLn(citizenValidator::getMessage);
            } else {
                return citizenValidator.getSsn();
            }
        }
    }

    Zip getZipFromConsole() {
        String inputString;

        while (true) {
            writeToConsole(() -> "Irányítószám: ");
            inputString = scanner.nextLine();

            if (!zipValidator.isValidZip(inputString)) {
                writeToConsoleLn(zipValidator::getMessage);
            } else {
                writeToConsoleLn(() -> "A megadott iránytószámhoz tartozó település: " + zipValidator.getZip().getSettlement());
                return zipValidator.getZip();
            }
        }
    }


    String getEmail(String email) {
        String inputString;

        while (true) {
            if (email == null) {
                writeToConsole(() -> "E-mail cím: ");
            } else {
                writeToConsole(() -> "E-mail cím ismét: ");
            }

            inputString = scanner.nextLine();

            if (!citizenValidator.isValidEmail(inputString)) {
                writeToConsoleLn(citizenValidator::getMessage);
            } else {
                return citizenValidator.getEmail();
            }
        }
    }

    LocalDate getVaccinationsTimeFromConsole() {
        String inputString;

        while (true) {
            writeToConsole(() -> "Az oltás / meghiúsulás dátuma (formátum: éééé-hh-nn): ");
            inputString = scanner.nextLine();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            try {
                return LocalDate.parse(inputString, dateFormat);
            } catch (DateTimeParseException e) {
                writeToConsoleLn(() -> "Hibás dátum formátum!");
            }
        }
    }

    Vaccine getVaccineFromConsole() {
        String inputString;
        List<Vaccine> vaccines = Arrays.asList(Vaccine.values());

        while (true) {
            writeToConsoleLn(() -> "Válasszon vakcina típust: ");
            vaccines.forEach(vaccine -> writeToConsoleLn(vaccine::toString));

            inputString = scanner.nextLine();

            try {
                return Vaccine.valueOf(inputString);
            } catch (IllegalArgumentException iae) {
                writeToConsoleLn(() -> "Nem létező vakcina! A vakcina megadásához használja a rövidítéseket!");
            }
        }
    }

    Path getFileWithPathFromConsole() {
        String inputString;

        while (true) {
            writeToConsole(() -> "Tömeges regsztrációs fájl (elérési úttal): ");
            inputString = scanner.nextLine();
            Path inputFile = Path.of(inputString);

            if (Files.isReadable(inputFile) && Files.isRegularFile(inputFile)) {
                return inputFile;
            }

            writeToConsoleLn(() -> "A fájl nem létezik!");
        }
    }

    String getSeparatorFromConsole() {
        String inputString;

        while (true) {
            writeToConsole(() -> "Adja meg az adatelválasztó karaktert: ");
            inputString = scanner.nextLine();

            if (inputString == null || inputString.length() != 1) {
                writeToConsoleLn(() -> "Hibás adatelválasztó!");
            } else {
                return inputString;
            }
        }
    }

    int getNumOfSkipLineFromConsole() {
        String inputString;
        HashMap<String, Integer> options = new HashMap<>();
        options.put("N", 1);
        options.put("I", 1);

        while (true) {
            writeToConsole(() -> "Tartalmaz fejlécet az adatforrás? (I/N) ");
            inputString = scanner.nextLine().toUpperCase();

            if (inputString.length() != 1 || !options.containsKey(inputString)) {
                writeToConsoleLn(() -> "Hibás válasz!");
            } else {
                return options.get(inputString);
            }
        }
    }

    String getRejectReasonFromConsole() {
        String inputString;

        while (true) {
            writeToConsole(() -> "Adja meg az oltás meghiúsúlás okát: ");
            inputString = scanner.nextLine();

            if (inputString == null || inputString.isBlank()) {
                writeToConsoleLn(() -> "Nem adott meg okot!");
            } else {
                return inputString;
            }
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
