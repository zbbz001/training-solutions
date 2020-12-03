package inheritanceconstructor.cars;

public class Jeep extends Car {

    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public void drive(int km) {
        double requiredFuel = 0;

        if (enoughFuel(km)) {
            requiredFuel = km / 100 * super.getFuelRate();
            extraFuel -= requiredFuel;
            if(extraFuel < 0) {
                super.modifyFuelAmount(extraFuel);
                extraFuel = 0;
            }
        } else {
            throw new RuntimeException("Not enough fuel available!");
        }
    }

    public double calculateRefillAmount() {
        return super.calculateRefillAmount() + extraCapacity - extraFuel;
    }

    private boolean enoughFuel(int km) {
        return km / 100 * super.getFuelRate() < super.getFuel() + extraFuel;
    }

    public double getExtraFuel() {
        return extraFuel;
    }
}
