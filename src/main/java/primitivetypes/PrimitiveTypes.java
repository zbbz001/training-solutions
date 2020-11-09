package primitivetypes;

public class PrimitiveTypes {
    public static final int BITS = 32;

    public String toBinaryString(int n) {
        String binaryNumber = "";

        for (int i = n; i > 0; ) {
            binaryNumber = (i % 2) + binaryNumber;
            i /= 2;
        }

        for (int i = binaryNumber.length(); i < BITS; i++) {
            binaryNumber = "0" + binaryNumber;
        }

        return binaryNumber;
    }

}
