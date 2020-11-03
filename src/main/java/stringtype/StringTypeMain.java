package stringtype;

public class StringTypeMain {

    public static void main(String[] args) {
        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;

        message += 444;

        Boolean b = message.equals("Hello John Doe");

        Boolean c = message.equals("Hello John Doe444");

        System.out.println(b);
        System.out.println(c);

        String emptyString = "";
        String emptyStringOther = "";

        String concatenatedString = emptyString + emptyStringOther;

        System.out.println(concatenatedString.length());

        String alphabetic = "Abcde";

        System.out.println(alphabetic.length());
        System.out.println(alphabetic.substring(0,1));
        System.out.println(alphabetic.substring(2,3));

    }
}
