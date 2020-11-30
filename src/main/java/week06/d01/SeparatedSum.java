package week06.d01;

public class SeparatedSum {
    final static String NUMBER_SEPARATOR = ";";
    final static String DECIMAL_SEPARATOR_IN_TEXT = ",";
    final static String DECIMAL_SEPARATOR = ".";

    public String sum(String s) {
        if(isEmpty(s)) {
            throw new IllegalArgumentException("The text that contains numbers cannot be null or empty.");
        }

        SortedNumbers sortedNumbers = new SortedNumbers();
        String[] textNumbers = s.split(NUMBER_SEPARATOR);

        for (String textNumber : textNumbers) {
            textNumber = changeDecimalSeparator(textNumber);
            sortedNumbers.sortNumber(Double.parseDouble(textNumber));
        }

        return sortedNumbers.toString();
    }

    private String changeDecimalSeparator(String str) {
        return str.replace(DECIMAL_SEPARATOR_IN_TEXT, DECIMAL_SEPARATOR);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
