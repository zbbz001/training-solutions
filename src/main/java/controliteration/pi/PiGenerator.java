package controliteration.pi;

public class PiGenerator {

    private static final String PI_POET = "Nem a régi s durva közelítés,\n" +
            "Mi szótól szóig így kijön\n" +
            "Betűiket számlálva.\n" +
            "Ludolph eredménye már,\n" +
            "Ha itt végezzük húsz jegyen.\n" +
            "De rendre kijő még tíz pontosan,\n" +
            "Azt is bízvást ígérhetem.\n" +
            "\t";

    public String makePiFromPoet() {
        String piString = "";
        int counter = 0;

        for (int i = 0; i < PI_POET.length(); i++) {
            if (counter != 0 && !Character.isAlphabetic(PI_POET.charAt(i))) {
                piString += counter;
                if (piString.length() == 1) {
                    piString += ",";
                }
                counter = 0;
            }
            if (Character.isAlphabetic(PI_POET.charAt(i))) {
                counter ++;
            }
        }
        return piString;
    }

    public static void main(String[] args) {
        PiGenerator piGenerator = new PiGenerator();

        System.out.println(piGenerator.makePiFromPoet());


    }
}
