package isahasa.fleet;

public class FerryBoat implements Ship, CanCarryGoods, CanCarryPassengers {
    private CanCarryGoods canCarryGoods;
    private CanCarryPassengers canCarryPassengers;

    public FerryBoat(int passengers, int maxCargoWeight) {
        canCarryGoods = new CanCarryGoodsBehaviour(maxCargoWeight);
        canCarryPassengers = new CanCarryPassengersBehaviour(passengers);
    }

    @Override
    public int loadCargo(int cargoWeight) {
        return canCarryGoods.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return canCarryGoods.getCargoWeight();
    }

    @Override
    public int loadPassenger(int passengers) {
        return canCarryPassengers.loadPassenger(passengers);
    }

    @Override
    public int getPassengers() {
        return canCarryPassengers.getPassengers();
    }
}
