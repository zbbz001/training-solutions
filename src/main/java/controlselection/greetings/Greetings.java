package controlselection.greetings;

import java.time.LocalTime;

public class Greetings {

    public String sayGreeting (int hours, int minutes) {
        LocalTime time = LocalTime.of(hours, minutes);

        if (time.isAfter(LocalTime.parse("20:00")) || time.isBefore(LocalTime.parse("05:01"))) {
            return "Jó éjt!";
        } else if (time.isAfter(LocalTime.parse("18:30"))) {
            return "Jó estét!";
        } else if (time.isAfter(LocalTime.parse("09:00"))) {
            return "Jó napot!";
        } else if (time.isAfter(LocalTime.parse("05:00"))) {
            return "Jó reggelt!";
        }

        return null;
    }


    public static void main(String[] args) {
        Greetings greetings = new Greetings();

        System.out.println(greetings.sayGreeting(4, 10));
        System.out.println(greetings.sayGreeting(5, 10));
        System.out.println(greetings.sayGreeting(9, 10));
        System.out.println(greetings.sayGreeting(19, 10));
        System.out.println(greetings.sayGreeting(20, 10));
    }
}
