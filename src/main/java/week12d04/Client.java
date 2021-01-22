package week12d04;

public class Client {
    private String name;
    private String regNumber;

    public Client(String name, String regNumber) {
        this.name = name;
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public String getRegNumber() {
        return regNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", regNumber='" + regNumber + '\'' +
                '}';
    }
}
