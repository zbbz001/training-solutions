package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {
        Person person1;
        Person person2;

        person1 = new Person("Cody Coder", 22);
        person2 = person1;

        System.out.println(person1);
        System.out.println(person2);

        int number1 = 24;
        int number2 = number1;

        number2++;

        System.out.println(number1);
        System.out.println(number2);

        Person person3 = new Person("Donald Duck", 1955);
        person2 = person3;

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
    }

}
