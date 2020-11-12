package introexception.patient;

public class SsnValidator {

    public boolean isValidSsn(String ssn) {
        if (ssn.length() != 9) {
            return false;
        }

        int checkSum = 0;
        try {
            for (int i = 0; i < 8; i++) {
                char c = ssn.charAt(i);

                if (c < '0' || c > '9') {
                    throw new IllegalArgumentException("Hibás ssn számot adot meg!");
                }

                if (i % 2 == 0) {
                    checkSum += 3 * c;
                } else {
                    checkSum += 7 * c;
                }
            }

            return checkSum % 10 == Integer.parseInt(String.valueOf(ssn.charAt(8)));
        } catch (IllegalArgumentException iae) {
            return false;
        }
    }
}
