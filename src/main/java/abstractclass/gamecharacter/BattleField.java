package abstractclass.gamecharacter;

public class BattleField {
    private int round;

    public Character fight(Character one, Character other) {
        while (oneHit(one, other) && oneHit(other, one)) {
            round++;
        }

        return one.isAlive() ? one : other;
    }

    private boolean oneHit(Character attacker, Character defender) {
        attacker.primaryAttack(defender);
        attacker.secondaryAttack(defender);

        return attacker.isAlive() && defender.isAlive();
    }

    public int getRound() {
        return round;
    }
}
