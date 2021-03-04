package covid.validator;

import covid.Zip;
import covid.dao.ZipDao;

import javax.sql.DataSource;

public class ZipValidator {
    private String message;
    private final DataSource dataSource;
    private Zip zip;

    public ZipValidator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean isValidZip(String str) {
        if (str == null || str.isEmpty()) {
            message = "Az irányítószám nem lehet üres!";
            return false;
        } else {
            zip = new ZipDao(dataSource).findZipByZipCode(str);
            if (zip != null) {
                return true;
            } else {
                message = "Az irányítószám nincs az adatbázisban, adjon meg újat!";
                return false;
            }
        }
    }

    public String getMessage() {
        return message;
    }

    public Zip getZip() {
        return zip;
    }

}
