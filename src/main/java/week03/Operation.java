package week03;

public class Operation {
    private int left;
    private int right;

    public Operation(String str) {
        left = Integer.parseInt(str.substring(0, str.indexOf("+")).trim());
        right = Integer.parseInt(str.substring(str.indexOf("+") + 1).trim());
    }

    public int getResult() {
        return left + right;
    }

}
