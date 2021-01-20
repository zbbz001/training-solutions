package week03d04;

public class PhoneParser {

    public Phone parse(String str) {
        String[] parts = str.split("-");

        return new Phone(parts[0], parts[1]);
    }

}
