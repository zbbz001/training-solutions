package abstractclass.gamecharacter;

import java.util.Random;

public class Archer extends Character {
    private int numberOfArrow;

    public Archer(Point position, Random random) {
        super(position, random);
        this.numberOfArrow = 100;
    }

    @Override
    public void secondaryAttack(Character enemy) {
        shootingAnArrow(enemy);
    }

    public int getActualSecondaryDamage() {
        return getRandom().nextInt(5) + 1;
    }

    private void shootingAnArrow(Character enemy) {
        numberOfArrow--;
        hit(enemy, getActualSecondaryDamage());
    }

    public int getNumberOfArrow() {
        return numberOfArrow;
    }
}
