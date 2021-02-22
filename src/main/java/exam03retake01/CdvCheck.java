package exam03retake01;

public class CdvCheck {

    public boolean check(String digitValue) {
        if (digitValue.length() != 10) {
            throw new IllegalArgumentException("The given digitnumber is incorrect");
        }

        char[] chars = digitValue.toCharArray();
        int value = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            if (!Character.isDigit(chars[i])) {
                throw new IllegalArgumentException("The given digitnumber is incorrect");
            }

            value += Character.getNumericValue(chars[i]) * (i + 1);
        }

        return Character.getNumericValue(chars[9]) == value % 11;
    }
}
