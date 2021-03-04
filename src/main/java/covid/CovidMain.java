package covid;

import covid.dao.CitizenDao;
import covid.module.*;
import covid.module.toConsole.*;
import covid.module.toConsole.Menu;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class CovidMain extends FromConsole {
    public CovidMain(DataSource dataSource) {
        super(dataSource);
    }

    private void run() {
        do {
            writeToConsoleLn(new Menu());
        }
        while (selectMenu(scanner.nextLine()));
    }

    private boolean selectMenu(String menu) {
        switch (menu) {
            case "1" -> {
                return collectDataAndSaveCitizen();
            }
            case "2" -> {
                return importMultipleCitizen();
            }
            case "3" -> {
                return generateVaccinationList();
            }
            case "4" -> {
                return vaccination();
            }
            case "5" -> {
                return rejectVaccination();
            }
            case "6" -> {
                return generateReportByZip();
            }
            case "0" -> writeToConsoleLn(() -> "-- Itt is voltunk --");
            default -> {
                writeToConsoleLn(() -> "Hibás menüpont, válasszon másikat!\n");
                return true;
            }
        }

        return false;
    }

    private boolean generateReportByZip() {
        writeToConsoleLn(new GenerateReportByZipHeader());
        new GenerateReport(dataSource).runModule();

        return true;
    }

    private boolean rejectVaccination() {
        writeToConsoleLn(new RejectVaccinationHeader());
        new CitizenRejectVaccination(dataSource).runModule();

        return true;
    }

    private boolean vaccination() {
        writeToConsoleLn(new VaccinationHeader());
        new CitizenVaccination(dataSource).runModule();

        return true;
    }

    private boolean generateVaccinationList() {
        writeToConsoleLn(new GenerateVaccinationListHeader());
        new VaccinationListGenerator(dataSource).runModule();

        return true;
    }

    private boolean importMultipleCitizen() {
        writeToConsoleLn(new ImportMultipleHeader());
        new CitizenImporter(dataSource).runModule();

        writeToConsoleLn(() -> "Az importálásnak vége!\n");

        return true;
    }

    private boolean collectDataAndSaveCitizen() {
        writeToConsoleLn(new CollectDataAndSaveHeader());

        try {
            Citizen citizen = new CitizenFromConsole(dataSource).runModule();
            new CitizenDao(dataSource).saveCitizen(citizen);

            writeToConsoleLn(() -> "Az állampolgár sikeresn rögzítve!\n");
        } catch (IllegalArgumentException iae) {
            writeToConsoleLn(iae::getMessage);
        }

        return true;
    }

    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();

        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot create data source");
        }

        new CovidMain(dataSource).run();
    }
}
