package week02d05;

import java.util.ArrayList;
import java.util.List;

public class Languages {

    public static void main(String[] args) {
        List<String> progList  = new ArrayList<>();

        progList.add("Java");
        progList.add("Python");
        progList.add("JavaScript");

        for (String progLang: progList ) {
            if (progLang.length() > 5) {
                System.out.println(progLang);
            }
        }
    }
}
