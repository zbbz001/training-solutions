package math.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
Picit át variálva, random játékos kezdi a kört.
 */

public class Game {

    public static void main(String[] args) {
        final Random rnd = new Random();
        Warrior blueCorner = new Warrior("Cody Coder", new Point(15, 5));
        Warrior redCorner = new Warrior("Donald Duck", new Point(8, 15));

        List<Warrior> players = new ArrayList<>();

        players.add(blueCorner);
        players.add(redCorner);

        for (int turn = 1; blueCorner.isAlive() && redCorner.isAlive(); turn++) {
            System.out.println(turn + ". round");
            System.out.println(blueCorner.toString());
            System.out.println(redCorner.toString());

            int firstStep = rnd.nextInt(2);
            Warrior firstPlayer = players.get(firstStep);
            Warrior secondPlayer = players.get(1 - firstStep);

            if(firstPlayer.distance(secondPlayer) > 1) {
                firstPlayer.move(secondPlayer);
                System.out.println(firstPlayer.getName() + " - mozgás");
            } else {
                firstPlayer.attack(secondPlayer);

                System.out.println(firstPlayer.getName() + " - támadás");
            }

            if(secondPlayer.isAlive()) {
                if (secondPlayer.distance(firstPlayer) > 1) {
                    secondPlayer.move(firstPlayer);
                    System.out.println(secondPlayer.getName() + " - mozgás");
                } else {
                    secondPlayer.attack(firstPlayer);
                    System.out.println(secondPlayer.getName() + " - támadás");
                }
            }

            if(firstPlayer.isAlive() && secondPlayer.isAlive()) {
                System.out.println("Kör vége:");
                System.out.println(blueCorner.toString());
                System.out.println(redCorner.toString());
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("A mérközés nyertese" + (blueCorner.isAlive() ? blueCorner.toString() : redCorner.toString()));
    }
}
