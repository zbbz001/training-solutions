package week09d03;

import java.util.ArrayList;
import java.util.List;

public class SantaClaus {
    private List<Person> personList = new ArrayList<>();

    public SantaClaus(List<Person> personList) {
        if (personList == null || personList.size() == 0) {
            throw new IllegalArgumentException("The list of persons cannot be empty, so no work today");
        }

        this.personList = personList;
    }

    public void getThroughChimneys() {
        for (Person person : personList) {
            person.setPresent();
        }
    }

    public List<Person> getPersonList() {
        return personList;
    }
}