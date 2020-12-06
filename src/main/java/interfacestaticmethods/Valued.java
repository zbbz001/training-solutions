package interfacestaticmethods;

import java.util.List;

public interface Valued {

    static double sum(List<Valued> list) {
        double sum = 0;
        for (Valued item : list) {
            sum += item.getValue();
        }

        return sum;
    }

    double getValue();
}
