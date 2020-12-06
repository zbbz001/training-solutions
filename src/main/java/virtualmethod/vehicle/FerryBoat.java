package virtualmethod.vehicle;

public class FerryBoat extends Vehicle {
    private int MAX_CARRY_WEIGHT = 2000;
    private Vehicle vehicle;

    public FerryBoat(int vehicleWeight) {
        super(vehicleWeight);
    }

    public boolean load(Vehicle vehicle) {
        if(canCarry(vehicle)) {
            this.vehicle = vehicle;
            return true;
        }

        return false;
    }

    public boolean canCarry(Vehicle vehicle) {
        return vehicle.getGrossLoad() < MAX_CARRY_WEIGHT;
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + vehicle.getGrossLoad();
    }

    @Override
    public String toString() {
        return "FerryBoat{" +
                "car=" + vehicle.toString() +
                "}";
    }
}
