package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Song song = new Song();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adja meg kedvenc zeneszáma adatait!");
        System.out.println("Szerző: ");
        song.band = scanner.nextLine();
        System.out.println("Cím: ");
        song.title = scanner.nextLine();
        System.out.println("hossz (mp): ");
        song.lenght = scanner.nextInt();

        System.out.println("Na nézzük, milyen zenét szeret!");
        System.out.println(song.band + " - " + song.title + " (" + song.lenght + "mp)");
    }
}
