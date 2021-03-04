package covid.validator;

public class SsnValidator {
    private static final String DEFAULT_ERROR_MSG = "A TAJ szám nem megfelelő!";
    private String message;
    private String ssn;

    public boolean isValidSsn(String str) {
        if (str.length() != 9) {
            message = DEFAULT_ERROR_MSG;
            return false;
        }

        char[] chars = str.toCharArray();
        int value = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            if (!Character.isDigit(chars[i])) {
                message = DEFAULT_ERROR_MSG;
                return false;
            }

            if (i % 2 == 0) {
                value += Character.getNumericValue(chars[i]) * 3;
            } else {
                value += Character.getNumericValue(chars[i]) * 7;
            }
        }

        if (Character.getNumericValue(chars[8]) == value % 10) {
            ssn = str;
            return true;
        } else {
            message = DEFAULT_ERROR_MSG;
            return false;
        }
    }

    public String getMessage() {
        return message;
    }

    public String getSsn() {
        return ssn;
    }
}
