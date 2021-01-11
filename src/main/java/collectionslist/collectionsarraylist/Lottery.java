package collectionslist.collectionsarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    private List<Integer> createBallList(int numOfBalls) {
        List<Integer> ballList = new ArrayList<>();
        for (int i = 0; i < numOfBalls; i++) {
            ballList.add(i + 1);
        }
        Collections.shuffle(ballList);

        return ballList;
    }

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }

        return createBallList(ballCount).subList(0, lotteryType);
    }
}
