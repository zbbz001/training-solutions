package literals;

public class LiteralsMain {

    public static void main(String[] args) {
        System.out.println("1" + "2");
        System.out.println(Integer.toString(1) + Integer.toString(2));

        double quotient = 3/4d;
        System.out.println(quotient);

        long bigNumber = 3_244_444_444L;
        System.out.println(bigNumber);

        String string = "árvíztűrőtükörfúrógép";
        System.out.println(string);

        String word = "title".toUpperCase();
        System.out.println(word);

        System.out.println(Integer.toBinaryString(11));
        System.out.println(Integer.toBinaryString(-11));
    }
}