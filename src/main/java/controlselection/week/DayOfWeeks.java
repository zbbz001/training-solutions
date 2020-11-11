package controlselection.week;

public class DayOfWeeks {

    public String dayInweek(String day) {

        switch(day.toLowerCase()) {
            case "hétfő":
                return "hét eleje";
            case "kedd":
            case "szerda":
            case "csütörtök":
                return "hét közepe";
            case "péntek":
                return "majdnem hétvége";
            case "szombat":
            case "vasárnap":
                return "hét vége";
            default:
                throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

    public static void main(String[] args) {
        DayOfWeeks day = new DayOfWeeks();

        System.out.println(day.dayInweek("hétfő"));
        System.out.println(day.dayInweek("vasárnap"));
        System.out.println(day.dayInweek("péntek"));
        System.out.println(day.dayInweek("kedd"));
        System.out.println(day.dayInweek("hét"));
    }
}
