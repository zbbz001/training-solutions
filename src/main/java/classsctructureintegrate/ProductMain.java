package classsctructureintegrate;

import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mi termék amit keres?");
        String productName = scanner.nextLine();

        System.out.println("Hmm, az drága lesz, mennyit ad érte?");
        int productPrice = scanner.nextInt();

        Product product = new Product(productName, productPrice);

        System.out.println("Nos, azt mondja, hogy " + product.getPrice() + " ért venné meg a(z) " + product.getName() + "-t");

        product.increasePrice(500);

        System.out.println("Legyen inkább " + product.getPrice() + ", így is baráti az ár!");
        System.out.println("Alkudna mi? Mennyit engedjek?");

        int bargain = scanner.nextInt();

        product.decreasePrice(bargain);

        System.out.println("Na jó, viheti a(z) " + product.getName() + "-t " + product.getPrice() + " ért, és többet ne lássam!");
    }
}
