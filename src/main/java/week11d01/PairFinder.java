package week11d01;

import java.util.ArrayList;
import java.util.List;

public class PairFinder {

    public int findPairs(int[] arr) {
        int numOfPairs = 0;
        List<Integer> numberList = new ArrayList<>();

        for (Integer number : arr) {
            if (numberList.contains(number)) {
                numOfPairs++;
                numberList.remove(number);
            } else {
                numberList.add(number);
            }
        }

        return numOfPairs;
    }
}
