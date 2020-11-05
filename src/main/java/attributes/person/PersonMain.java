package attributes.person;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Codyy Coder", "M00n-0-0-00",
                new Address("Moon", "Kepler crater", " The dark side of the moon str. 889.", "00110"));

        System.out.println(person.personToString());
        System.out.println(person.getAddress().addressToString());

        person.correctData("Cody Coder", "vENUs-200");
        System.out.println(person.personToString());
        person.moveTo(new Address("Venus", "Yoko crater", "Life on Venus str. 11", "7854"));
        System.out.println(person.getAddress().addressToString());
    }
}
