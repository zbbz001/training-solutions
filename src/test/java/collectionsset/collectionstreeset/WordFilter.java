package collectionsset.collectionstreeset;

import java.util.Set;
import java.util.TreeSet;

public class WordFilter {

    public Set<String> filterWords(String[] randomStrings) {
        Set<String> filteredList = new TreeSet<>();
        for (String str : randomStrings) {
            filteredList.add(str);
        }

        return filteredList;
    }
}
