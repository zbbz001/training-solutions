package stringbasic.stringbasic;

public class StringCreator {

    public String createStringForHeap() {
        return new String("blabla");
    }

    public String createStringForPool() {
        return "blabla";
    }

}
