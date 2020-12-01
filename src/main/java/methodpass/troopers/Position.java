package methodpass.troopers;

public class Position {
    private double posX;
    private double posY;

    public double distanceFrom(Position position) {
        return Math.sqrt(Math.pow(posX - position.getPosX(), 2) + Math.pow(posY - position.getPosY(), 2));
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public Position(double x, double y) {
        this.posX = x;
        this.posY = y;
    }
}
