package methodstructure.pendrives;

public class Pendrive {
    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public void risePrice(int percent) {
        price *= 1 + percent / 100.0;
    }

    public int comparePricePerCapacity(Pendrive otherPendrive) {
        if (PricePerCapacity() > otherPendrive.PricePerCapacity()) {
            return 1;
        }
        if (PricePerCapacity() < otherPendrive.PricePerCapacity()) {
            return -1;
        }
        return 0;
    }

    public boolean cheaperThan(Pendrive otherPendrive) {
        return getPrice() < otherPendrive.getPrice();
    }

    private double PricePerCapacity() {
        return (double)getPrice() / getCapacity();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
