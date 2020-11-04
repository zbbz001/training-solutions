package week02;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public boolean areTheyEqual(Product p) {
        return name.equals(p.getName());
    }

    public static void main(String[] args) {
        Product mars = new Product("Mars", "00001");
        Product sportSzelet = new Product("Sport Szelet", "0120");
        Product snickers = new Product("Snickers", "983001");

        System.out.println(mars.getName() + " és " + sportSzelet.getName() + " azonosak? " + mars.areTheyEqual(sportSzelet));
        System.out.println(mars.getName() + " és " + mars.getName() + " azonosak? " + mars.areTheyEqual(mars));
        System.out.println(snickers.getName() + " és " + mars.getName() + " azonosak? " + snickers.areTheyEqual(mars));


    }
}
