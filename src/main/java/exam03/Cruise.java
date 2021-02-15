package exam03;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cruise {
    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() < boat.getMaxPassengers()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("No available seat on the boat!");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        return passenger.getCruiseClass().getRate() * basicPrice;
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(name)) {
                return passenger;
            }
        }

        return new Passenger();
    }

    public List<String> getPassengerNamesOrdered() {
        return passengers.stream()
                .map(Passenger::getName)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public double sumAllBookingsCharged() {
        return passengers.stream()
                .map(this::getPriceForPassenger)
                .reduce(0.0, Double::sum);
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        return passengers.stream()
                .map(Passenger::getCruiseClass)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(value -> 1)));
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}
