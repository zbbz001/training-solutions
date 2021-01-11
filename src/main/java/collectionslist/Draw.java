package collectionslist;

import java.util.*;

public class Draw {

    private List<Integer> createNumberPool(int numOfBalls) {
        List<Integer> ballList = new LinkedList<>();
        for (int i = 0; i < numOfBalls; i++) {
            ballList.add(i + 1);
        }
        Collections.shuffle(ballList);

        return ballList;
    }

    public Set<Integer> drawNumbers(int drawCount, int maxNumber) {
        if (drawCount >= maxNumber) {
            throw new IllegalArgumentException("drawCount must be less then " + maxNumber + "!");
        }

        return new TreeSet<>(createNumberPool(maxNumber).subList(0, drawCount));
    }
}
