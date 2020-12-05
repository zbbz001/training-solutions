package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {
    private Point position;
    private int hitPoint;
    private Random random;

    public Character(Point position, Random random) {
        this.position = position;
        this.random = random;
        hitPoint = 100;
    }

    public boolean isAlive() {
        return hitPoint > 0;
    }

    public void primaryAttack(Character enemy) {
        hit(enemy, getActualPrimaryDamage());
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public Point getPosition() {
        return position;
    }

    protected int getActualPrimaryDamage() {
        return random.nextInt(9) + 1;
    }

    protected void hit(Character enemy, int damage) {
        if(enemy.getActualPrimaryDamage() < damage) {
            enemy.decreaseHitPoint(damage);
        }
    }

    private int getActualDefence() {
        return random.nextInt(6);
    }

    private void decreaseHitPoint(int diff) {
        hitPoint -= diff;
    }

    abstract public void secondaryAttack(Character enemy);

    public Random getRandom() {
        return random;
    }
}