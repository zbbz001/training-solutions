package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String str) {
        if (str == null) {
            throw new NullPointerException("binaryString null");
        }

        boolean[] arr = new boolean[str.length()];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '1') {
                arr[i] = true;
            } else if (c == '0') {
                arr[i] = false;
            } else {
                throw new IllegalArgumentException("binaryString not valid");
            }
        }

        return arr;
    }

    public String booleanArrayToBinaryString(boolean[] arr) {
        if (arr.length == 0 || arr == null) {
            throw new IllegalArgumentException("The array cannot be null.");
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == true) {
                sb.append(1);
            } else if (arr[i] == false) {
                sb.append(0);
            }
        }

        return sb.toString();
    }
}
