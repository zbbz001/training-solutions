package covid.module.toConsole;

public class GenerateVaccinationListHeader implements ConsoleWriter {
    @Override
    public String write() {
        return """
                                
                ****************************
                *** Vakcinációs jegyzék  ***
                ****************************
                """;
    }
}
