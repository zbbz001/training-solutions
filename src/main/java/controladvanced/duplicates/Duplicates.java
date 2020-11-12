package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {


    public List<Integer> filterDuplicates(List<Integer> elements) {
        List<Integer> duplicates = new ArrayList<>();

        for(int i = 0; i < elements.size(); i++) {
            int element = elements.get(i);
            if(!duplicates.contains(element)) {
                for(int j = i + 1; j < elements.size(); j++) {
                    if(elements.get(j) == element) {
                        duplicates.add(element);
                        break;
                    }
                }
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        Duplicates duplicates = new Duplicates();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(2);

        System.out.println(duplicates.filterDuplicates(list));
    }

}
