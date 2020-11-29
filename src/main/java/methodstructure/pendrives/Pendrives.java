package methodstructure.pendrives;

import java.util.ArrayList;
import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendriveList) {
        Pendrive bestPendrive = pendriveList.get(0);

        for (int i = 0; i < pendriveList.size(); i++) {
            if (bestPendrive.comparePricePerCapacity(pendriveList.get(i)) == 1) {
                bestPendrive = pendriveList.get(i);
            }
        }

        return bestPendrive;
    }

    public Pendrive cheapest(List<Pendrive> pendriveList) {
        Pendrive cheapestPendrive = pendriveList.get(0);

        for (int i = 0; i < pendriveList.size(); i++) {
            if (pendriveList.get(i).cheaperThan(cheapestPendrive)) {
                cheapestPendrive = pendriveList.get(i);
            }
        }

        return cheapestPendrive;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendriveList, int percent, int capacity) {
        for (Pendrive pendrive : pendriveList) {
            if (pendrive.getCapacity() == capacity) {
                pendrive.risePrice(percent);
            }
        }
    }
}
