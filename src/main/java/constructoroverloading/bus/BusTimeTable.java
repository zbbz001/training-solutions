package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {
    List<SimpleTime> timeTable = new ArrayList<>();

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        for (int i = firstHour; i <= lastHour; i++) {
            timeTable.add(new SimpleTime(i, everyMinute));
        }
    }

    public SimpleTime nextBus(SimpleTime actual) {
        for (SimpleTime departure : timeTable) {
            if (departure.difference(actual) > 0) {
                return departure;
            }
        }

        throw new IllegalStateException("No more buses today!");
    }

    public SimpleTime firstBus() {
        SimpleTime firstBus = timeTable.get(0);

        for (SimpleTime departure : timeTable) {
            if (departure.difference(firstBus) < 0) {
                firstBus = departure;
            }
        }

        return firstBus;
    }

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }
}
