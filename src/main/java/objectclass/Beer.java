package objectclass;

public class Beer {
    private String name;
    private int price;

    public Beer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return name.equals(((Beer) o).name) && price == ((Beer) o).price;
    }
}
