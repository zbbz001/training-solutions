package week02d03;

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

    public String getCode() {
        return code;
    }

    public boolean areTheyEqual(Product p) {
        return name.equals(p.getName());
    }

    public boolean codeCheck(Product p) {
        return Math.abs(code.length() - p.getCode().length()) <= 1;
    }

    public static void main(String[] args) {
        Product mars = new Product("Mars", "00001");
        Product mars2 = new Product("Mars2", "01");
        Product sportSzelet = new Product("Sport Szelet", "0120");
        Product sportSzelet2 = new Product("Sport Szelet2", "012");
        Product snickers = new Product("Snickers", "983001");

        System.out.println(mars.getName() + " és " + sportSzelet.getName() + " azonosak? " + mars.areTheyEqual(sportSzelet));
        System.out.println(mars.getName() + " és " + mars.getName() + " azonosak? " + mars.areTheyEqual(mars));
        System.out.println(snickers.getName() + " és " + mars.getName() + " azonosak? " + snickers.areTheyEqual(mars));
        System.out.println("-extra-");
        System.out.println(mars2.getName() + " és " + mars.getName() + " azonosak? " + mars2.codeCheck(mars));
        System.out.println(sportSzelet.getName() + " és " + sportSzelet2.getName() + " azonosak? " + sportSzelet.codeCheck(sportSzelet2));
    }
}
