package primitivetypes;

public class PrimitiveTypesMain {

    public static void main(String[] args) {


        System.out.println(new PrimitiveTypes().toBinaryString(5));

        System.out.println(Integer.toBinaryString(5));

        System.out.println(new Integer(1) + new Integer(2));

        boolean b = Boolean.parseBoolean("ajaj");
        int a = Integer.parseInt("23");
        String s = Integer.toString(23);
        System.out.println(s);

    }

}
