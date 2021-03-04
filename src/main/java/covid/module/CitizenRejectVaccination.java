package covid.module;

import covid.Citizen;
import covid.Vaccination;
import covid.dao.CitizenDao;
import covid.dao.VaccinationsDao;

import javax.sql.DataSource;
import java.time.LocalDate;

public class CitizenRejectVaccination extends FromConsole {
    private final VaccinationsDao vaccinationsDao;

    public CitizenRejectVaccination(DataSource dataSource) {
        super(dataSource);
        vaccinationsDao = new VaccinationsDao(dataSource);
    }

    public void runModule() {
        String ssn = getSsnFromConsole();
        LocalDate vaccinationDate = getVaccinationsTimeFromConsole();

        Citizen citizen = new CitizenDao(dataSource).findCitizenBySsn(ssn);

        if (citizen == null) {
            writeToConsoleLn(() -> "A megadott TAJ szám alapján nincs oltásra regisztrált");
        } else {
            String rejectReason = getRejectReasonFromConsole();

            vaccinationsDao.saveNewVaccination(new Vaccination(citizen.getId(), vaccinationDate, 9, rejectReason, null));

            writeToConsoleLn(() -> "Az adatok rögzítve!");
        }
    }
}
