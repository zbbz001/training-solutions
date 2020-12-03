package inheritanceconstructor.classroom;

public class Room {
    private String location;
    private int capacity;

    public Room(String location, int capacity) {
        this.location = location;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }
}
