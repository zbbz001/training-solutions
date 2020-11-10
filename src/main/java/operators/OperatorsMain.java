package operators;

public class OperatorsMain {
    public static void main(String[] args) {
        System.out.println(new Operators().isEven(2));
        System.out.println(new Operators().isEven(21));

        System.out.println(16 >> 1);
        System.out.println(16 << 1);
        System.out.println(32 >> 1);
        System.out.println(32 << 1);

        System.out.println(new Operators().multiplyByPowerOfTwo(4, 4 ));

        //Miért ad a következő kódrészlet kivételt?
        //mert az 11111111111111111111111111111111 kivülesik az int értékkészletén, mivel pozitív számként értelmezi,
        //negatívhoz ki kell tenni az előjelet.

        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        //int j = Integer.parseInt(s, 2);
        //System.out.println(j);

        //a 0 kezdő számjegy miatt oktális számrendszerben van megadva az érték (219)
        System.out.println(0333);
    }
}
