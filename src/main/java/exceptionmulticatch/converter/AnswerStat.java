package exceptionmulticatch.converter;

public class AnswerStat {
    BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public boolean[] convert(String str) {
        try {
            return binaryStringConverter.binaryStringToBooleanArray(str);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new InvalidBinaryStringException(e);
        }
    }

    public int answerTruePercent(String answers) {
        int trues = 0;
        boolean[] arr = convert(answers);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == true) {
                trues++;
            }
        }
        return trues * 100 / arr.length;
    }
}
