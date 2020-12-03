package inheritanceconstructor.cars;

public class Car {
    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (tankCapacity < fuel) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }

        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        this.fuel += fuel;
    }

    public void drive(int km) {
        if (enoughFuel(km)) {
            fuel -= km / 100 * fuelRate;
        } else {
            throw new RuntimeException("Not enough fuel available!");
        }
    }

    private boolean enoughFuel(int km) {
        return km / 100 * fuelRate < fuel;
    }

    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }
}
