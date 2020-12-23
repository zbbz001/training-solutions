package week09d03;

import java.util.List;
import java.util.Random;

public class Person {
    private String name;
    private int age;
    private Present present;
    private static final Random RANDOM = new Random();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPresent() {
        present = Present.values()[(RANDOM.nextInt(Present.values().length))];

        if (age > 14 && present.equals(Present.Toy)) {
            setPresent();
        }
    }

    public Present getPresent() {
        return present;
    }

    public int getAge() {
        return age;
    }
}


