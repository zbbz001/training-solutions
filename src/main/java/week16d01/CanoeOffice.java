package week16d01;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CanoeOffice {
    private List<CanoeRental> rentals = new ArrayList<>();
    private int HOUR_PRICE = 5000;

    public void createRental(CanoeRental canoeRental) {
        rentals.add(canoeRental);
    }

    public CanoeRental findRentalByName(String name) {
        for (CanoeRental rental : rentals) {
            if (rental.getName().equals(name)) {
                return rental;
            }
        }

        return new CanoeRental();
    }

    public void closeRentalByName(String name, LocalDateTime endTime) {
        CanoeRental rental = findRentalByName(name);
        if (rental.getName() == null || rental.getEndTime() != null) {
            throw new IllegalStateException("there is no open rental with this name!");
        }

        rental.setEndTime(endTime);
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        CanoeRental rental = findRentalByName(name);
        if (rental.getName() == null) {
            throw new IllegalStateException("there is no rental with this name!");
        }

        CanoeRental canoeRentalForCal = new CanoeRental(rental);
        canoeRentalForCal.setEndTime(endTime);

        return canoeRentalForCal.calculateRentalSum() * HOUR_PRICE;
    }

    public List<CanoeRental> listClosedRentals() {
        List<CanoeRental> orderedRentals = new ArrayList<>();

        for (CanoeRental rental : rentals) {
            if (rental.getEndTime() != null) {
                orderedRentals.add(rental);
            }
        }
        Collections.sort(orderedRentals);

        return orderedRentals;
    }

    public Map<CanoeType, Integer> countRentals() {
        Map<CanoeType, Integer> typeStatistic =
                Arrays.stream(CanoeType.values())
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(value -> 0)));

        rentals.stream()
                .map(CanoeRental::getCanoeType)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(value -> 1)))
                .forEach((k, v) -> typeStatistic.merge(k, v, Integer::sum));

        return typeStatistic;
    }

    public static void main(String[] args) {
        CanoeOffice co = new CanoeOffice();
        co.createRental(new CanoeRental("1", CanoeType.RED, "2020-01-01 00:00:00"));
        co.createRental(new CanoeRental("2", CanoeType.GREEN, "2020-01-01 00:00:00"));
        co.createRental(new CanoeRental("3", CanoeType.RED, "2020-01-01 00:00:00"));
        co.createRental(new CanoeRental("4", CanoeType.RED, "2020-01-01 00:00:00"));
        co.createRental(new CanoeRental("5", CanoeType.RED, "2020-01-01 00:00:00"));
        co.createRental(new CanoeRental("6", CanoeType.GREEN, "2020-01-01 00:00:00"));
        co.createRental(new CanoeRental("7", CanoeType.RED, "2020-01-01 00:00:00"));

        System.out.println(co.countRentals());

    }

}
