package methodoverloading.pub;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {
    private List<Pub> goodPubs = new ArrayList<>();

    public Pub findTheBest() {
        Pub bestPub = goodPubs.get(0);

        for (Pub pub : goodPubs) {
            if (pub.getOpenFrom().isEarlier(bestPub.getOpenFrom()))
                bestPub = pub;
        }

        return bestPub;
    }

    private boolean isEmpty(List<Pub> pubList) {
        return pubList == null || pubList.size() == 0;
    }

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (isEmpty(goodPubs)) {
            throw new IllegalArgumentException("Pub list is empty!");
        }

        this.goodPubs = goodPubs;
    }
}
