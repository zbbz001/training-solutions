package covid.module;

import covid.Citizen;
import covid.Vaccination;
import covid.Vaccine;
import covid.dao.CitizenDao;
import covid.dao.VaccinationsDao;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class CitizenVaccination extends FromConsole {
    public static final int MIN_VACC_PERIOD = 15;
    private final VaccinationsDao vaccinationsDao;

    public CitizenVaccination(DataSource dataSource) {
        super(dataSource);
        vaccinationsDao = new VaccinationsDao(dataSource);
    }

    public void runModule() {
        String ssn = getSsnFromConsole();
        List<Vaccination> vaccinations = getCitizenVaccinations(ssn);

        List<Vaccination> successfulVaccinations = vaccinations.stream()
                .filter(vaccination -> vaccination.getVaccinationStatus() == 1)
                .collect(Collectors.toList());

        switch (successfulVaccinations.size()) {
            case 0 -> firstVaccination(ssn);
            case 1 -> secondVaccination(successfulVaccinations);
            case 2 -> allVaccinationDone(vaccinations);
            default -> writeToConsoleLn(() -> "Hiba az oltás kezelés során!");
        }
    }

    private void firstVaccination(String ssn) {
        Citizen citizen = new CitizenDao(dataSource).findCitizenBySsn(ssn);

        if (citizen == null) {
            writeToConsoleLn(() -> "A megadott TAJ szám nincs regisztrálva oltásra!");
        } else {
            LocalDate vaccinationDate = getVaccinationsTimeFromConsole();
            Vaccine vaccine = getVaccineFromConsole();

            vaccinationsDao.saveNewVaccination(new Vaccination(citizen.getId(), vaccinationDate, 1, null, vaccine));

            writeToConsoleLn(() -> "Az oltás sikeresen rögzítve!");
        }
    }

    private void secondVaccination(List<Vaccination> successfulVaccinations) {
        if (successfulVaccinations.size() != 1) {
            writeToConsoleLn(() -> "Hiba a második oltás során!");
            return;
        }

        writeToConsoleLn(() -> "Az adott TAJ számra, már 1 oltás van regisztrálva!");

        writeToConsoleSuccessfulVaccination(successfulVaccinations);

        Vaccination lastVaccination = successfulVaccinations.get(0);
        LocalDate newVaccinationDate = getVaccinationsTimeFromConsole();
        LocalDate lastVaccinationDate = lastVaccination.getVaccinationTime();

        if (DAYS.between(lastVaccinationDate, newVaccinationDate) > MIN_VACC_PERIOD) {
            vaccinationsDao.saveNewVaccination(new Vaccination(lastVaccination.getCitizenId(), newVaccinationDate, 1, null, lastVaccination.getVaccine()));
            writeToConsoleLn(() -> "Az oltás sikeresen rögzítve!");
        } else {
            writeToConsoleLn(() -> "Nem adható oltás, az elöző oltás óta nem telt el " + MIN_VACC_PERIOD + " nap!");
        }
    }

    protected void allVaccinationDone(List<Vaccination> vaccinations) {
        writeToConsoleLn(() -> "Az adott TAJ számra, már 2 oltás van regisztrálva!\n");
        writeToConsoleSuccessfulVaccination(vaccinations);
    }

    private void writeToConsoleSuccessfulVaccination(List<Vaccination> vaccinationList) {
        writeToConsoleLn(() -> "Oltás információk:");

        vaccinationList.stream()
                .filter(vaccination -> vaccination.getVaccinationStatus() == 1)
                .sorted(Comparator.comparing(Vaccination::getVaccinationTime))
                .forEach(vaccination -> writeToConsoleLn(vaccination::getVaccinationInfoText));
    }

    private List<Vaccination> getCitizenVaccinations(String ssn) {
        return vaccinationsDao.selectCitizenVaccinations(ssn);
    }
}
