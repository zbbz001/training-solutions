package week15d02;

import java.time.LocalTime;

public class Order {
    private String postcode;
    private String address;
    private String houseNumber;
    private LocalTime time;

    public Order(String postcode, String address, String houseNumber, LocalTime time) {
        this.postcode = postcode;
        this.address = address;
        this.houseNumber = houseNumber;
        this.time = time;
    }

    public Order() {
    }

    public Order orderFromString(String line) {
        String[] parts = line.split(" ");
        String[] timeParts = parts[3].split(":");

        return new Order(parts[0], parts[1], parts[2], LocalTime.of(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1])));
    }

    public LocalTime getTime() {
        return time;
    }

    public String getAddress() {
        return postcode + " " + address + " " + houseNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "postcode='" + postcode + '\'' +
                ", address='" + address + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", time=" + time +
                '}';
    }
}
