package typeconversion.whichtype;

public class WhichTypeMain {
    public static void main(String[] args) {
        WhichType whichType = new WhichType();

        System.out.println(whichType.whichType(Long.toString(22)));
        System.out.println(whichType.whichType(Long.toString(222)));
        System.out.println(whichType.whichType(Long.toString(99922)));
        System.out.println(whichType.whichType(Long.toString(Long.MAX_VALUE - 1000)));
    }
}
