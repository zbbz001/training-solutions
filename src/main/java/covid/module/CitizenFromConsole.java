package covid.module;

import covid.Citizen;
import covid.Zip;
import covid.dao.CitizenDao;

import javax.sql.DataSource;

public class CitizenFromConsole extends FromConsole {
    private String inputEmail1;
    private String inputEmail2;

    public CitizenFromConsole(DataSource dataSource) {
        super(dataSource);
    }

    public Citizen runModule() {
        String name = getCitizenNameFromConsole();
        Zip zip = getZipFromConsole();
        int age = getAgeFromConsole();
        String email = getEmailsFromConsole();
        String ssn = getSsnFromConsole();

        CitizenDao citizenDao = new CitizenDao(dataSource);

        if (citizenDao.findCitizenBySsn(ssn) != null) {
            throw new IllegalArgumentException("A TAJ szám már regisztrálva van!");
        }

        return new Citizen(name, zip, age, email, ssn);
    }

    private String getEmailsFromConsole() {
        while (inputEmail1 == null || inputEmail2 == null) {
            inputEmail1 = getEmail(inputEmail1);
            inputEmail2 = getEmail(inputEmail1);

            if (!citizenValidator.isSameEmails(inputEmail1, inputEmail2)) {
                inputEmail1 = null;
                inputEmail2 = null;
                writeToConsoleLn(citizenValidator::getMessage);
            }
        }

        return citizenValidator.getEmail();
    }
}
