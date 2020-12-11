package week06d03;

import java.util.List;

public class Series {
    private boolean isGrowing = true;
    private boolean isDecreasing = true;

    public ListType calculateSeriesType(List<Integer> numberList) {
        if (numberList == null || numberList.size() < 2) {
            throw new IllegalArgumentException("The number's list is null or contains few numbers.");
        }

        int refNumber = numberList.get(0);

        for (int number : numberList) {
            investigateNumbers(refNumber, number);
            refNumber = number;
        }

        return getSerieType();
    }

    private void investigateNumbers(int refNumber, int number) {
        if (number < refNumber) {
            isGrowing = false;
        }

        if (number > refNumber) {
            isDecreasing = false;
        }
    }

    private ListType getSerieType() {
        for (ListType type : ListType.values()) {
            if (type.isGrowing() == isGrowing && type.isDecreasing() == isDecreasing) {
                return type;
            }
        }

        return null;
    }
}
