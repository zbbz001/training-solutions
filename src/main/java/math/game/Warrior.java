package math.game;

import java.util.Random;

public class Warrior {
    private final Random rnd = new Random();

    private String name;
    private int stamina;
    private double skill;
    private Point position;

    public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
        this.stamina = rnd.nextInt(81) + 20;
        this.skill = rnd.nextDouble();
    }

    public static void main(String[] args) {
        Warrior warrior = new Warrior("Cody Coder", new Point(2, 5));
        warrior.getPosition();
    }

    public Point getPosition() {
        return position;
    }

    public void move(Warrior enemy) {
        int newXCoordinate = position.getX();
        int newYCoordinate = position.getY();

        if (position.getX() - enemy.position.getX() > 0) {
            newXCoordinate--;
        } else {
            newXCoordinate++;
        }

        if (position.getY() - enemy.position.getY() > 0) {
            newYCoordinate--;
        } else {
            newYCoordinate++;
        }

        position = new Point(newXCoordinate, newYCoordinate);
    }

    public String getName() {
        return name;
    }

    public void attack(Warrior enemy) {
        if(rnd.nextDouble() < skill)
            enemy.stamina -= rnd.nextInt(3) + 1;
    }

    public double distance(Warrior enemy) {
        return position.distance(enemy.position);
    }

    public boolean isAlive() {
        return stamina > 0;
    }

    public String toString() {
        return "név: " + name + "(" + position.getX() + ", " + position.getY() + ") életerő: " + stamina;
    }
}
