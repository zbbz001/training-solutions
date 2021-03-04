package covid.validator;

import covid.Citizen;
import covid.Zip;
import covid.dao.CitizenDao;

import javax.sql.DataSource;

public class CitizenValidator {
    private static final int NUM_OF_FIELDS = 5;
    private static final int AGE_MIN = 10;
    private static final int AGE_MAX = 150;
    private static final int EMAIL_MIN_LENGTH = 3;

    private String message;
    private final ZipValidator zipValidator;

    private String name;
    private int age;
    private String email;
    private String ssn;
    private Zip zip;

    private DataSource dataSource;

    public CitizenValidator(DataSource dataSource) {
        this.dataSource = dataSource;
        this.zipValidator = new ZipValidator(dataSource);
    }

    public boolean validateFromLine(String separator, String line) {
        String[] parts = line.split(separator);

        if (parts.length != NUM_OF_FIELDS) {
            message = "A {line}. sor, nem megfelelő számú adat: ";
            return false;
        }

        boolean isValidZip = zipValidator.isValidZip(parts[1]);

        if (isValidName(parts[0]) && isValidZip && isValidAge(parts[2]) && isValidEmail(parts[3]) && isValidSsn(parts[4]) && !isSsnExist(parts[4])) {
            zip = zipValidator.getZip();
            return true;
        } else {
            message = "A {line}. sor, hibás adatok: ";
            return false;
        }
    }

    private boolean isSsnExist(String ssn) {
        CitizenDao citizenDao = new CitizenDao(dataSource);
        return citizenDao.findCitizenBySsn(ssn) != null;
    }

    public boolean isValidName(String str) {
        if (str == null || str.isEmpty()) {
            message = "A név nem lehet üres!";
            return false;
        }

        name = str;
        return true;
    }

    public boolean isValidAge(String str) {
        try {
            int inputAge = Integer.parseInt(str);

            if (inputAge < AGE_MIN || inputAge > AGE_MAX) {
                message = "Az életkornak " + AGE_MIN + " és " + AGE_MAX + " között kell lennie!";
                return false;
            } else {
                age = inputAge;
                return true;
            }
        } catch (NumberFormatException nfe) {
            message = "Nem számot adott meg!";
            return false;
        }
    }

    public boolean isValidEmail(String str) {
        if (str.contains("@") && str.length() > EMAIL_MIN_LENGTH) {
            email = str;
            return true;
        } else {
            message = "Az email cím nem megfelelő!";
            return false;
        }
    }

    public boolean isSameEmails(String email, String email2) {
        if (!email.equals(email2)) {
            message = "A megadott e-mail címek nem egyeznek!";
            return false;
        }

        return true;
    }

    public boolean isValidSsn(String str) {
        SsnValidator ssnValidator = new SsnValidator();
        if (!ssnValidator.isValidSsn(str)) {
            message = ssnValidator.getMessage();
            return false;
        } else {
            ssn = str;
            return true;
        }
    }

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public Citizen makeCitizen() {
        return new Citizen(name, zip, age, email, ssn);
    }

    public String getMessage() {
        return message;
    }
}
