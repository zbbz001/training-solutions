package controlselection.month;

public class DayInMonth {

    public int numOfDaysInMonth(int year, String month) {
        switch (month.toLowerCase()) {
            case "január":
            case "március":
            case "május":
            case "július":
            case "augusztus":
            case "október":
            case "december":
                return 31;
            case "április":
            case "június":
            case "szeptember":
            case "november":
                return 30;
            case "február":
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    public static void main(String[] args) {
        DayInMonth dayInMonth = new DayInMonth();
        System.out.println(dayInMonth.numOfDaysInMonth(1999, "január"));
        System.out.println(dayInMonth.numOfDaysInMonth(1999, "február"));
        System.out.println(dayInMonth.numOfDaysInMonth(2000, "február"));
        System.out.println(dayInMonth.numOfDaysInMonth(1900, "február"));
        System.out.println(dayInMonth.numOfDaysInMonth(2007, "február"));
        System.out.println(dayInMonth.numOfDaysInMonth(1341, "december "));

    }
}
