package methodpass.troopers;

public class Trooper {
    private String name;
    private Position position;

    public void changePosition(Position target) {
        if(target == null) {
            throw new IllegalArgumentException("The target position is invalid.");
        }

        position = target;
    }

    public double distanceFrom(Position target) {
        if(target == null) {
            throw new IllegalArgumentException("The target position is invalid.");
        }

        return position.distanceFrom(target);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Trooper(String name) {
        if(isEmpty(name)) {
            throw new IllegalArgumentException("Name must not be empty.");
        }

        this.name = name;
        position = new Position(0, 0);
    }
}
