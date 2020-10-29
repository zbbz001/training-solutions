package classsctructureconstructors;

public class StoreMain {

    public static void main(String[] args) {
        Store storeA = new Store("túlélőkészlet");
        Store storeB = new Store("kertitörpe");

        System.out.println("A raktárakban van: " + storeA.getStock() + "db " + storeA.getProduct() + ", illetve " + storeB.getStock() + "db " + storeB.getProduct() + ".");
        System.out.println();
        System.out.println("Hoppá érkezett 10 darab " + storeA.getProduct() + ".");
        storeA.store(10);
        System.out.println("Újra számolva, a raktárakban van: " + storeA.getStock() + "db " + storeA.getProduct() + ", illetve " + storeB.getStock() + "db " + storeB.getProduct() + ".");
        System.out.println();
        System.out.println("A szállítás folyamatos, érkezett 53 darab " + storeB.getProduct() + ".");
        storeB.store(53);
        System.out.println("Újra számolva, a raktárakban van: " + storeA.getStock() + "db " + storeA.getProduct() + ", illetve " + storeB.getStock() + "db " + storeB.getProduct() + ".");
        System.out.println();
        System.out.println("Nagy a jövés-menés elvittek 5 darab " + storeA.getProduct() + " és 17 darab " + storeA.getProduct() + ".");
        storeA.dispatch(5);
        storeB.dispatch(17);
        System.out.println("Újra számolva, a raktárakban van: " + storeA.getStock() + "db " + storeA.getProduct() + ", illetve " + storeB.getStock() + "db " + storeB.getProduct() + ".");
        System.out.println();
        System.out.println();
        System.out.println("Raktár mára bezárt!");
    }

}
