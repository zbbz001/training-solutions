package week11d04;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class NameLength {

    public List<Integer> getLengths(List<String> nameList) {
        if (nameList.isEmpty()) {
            throw new IllegalArgumentException("The list of names cannot be empty!");
        }

        TreeSet<Integer> nameLengths = new TreeSet<>();
        for (String name : nameList) {
            if (name.startsWith("J")) {
                nameLengths.add(name.length());
            }
        }

        return new ArrayList<>(nameLengths);
    }
}
