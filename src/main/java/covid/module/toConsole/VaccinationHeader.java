package covid.module.toConsole;

public class VaccinationHeader implements ConsoleWriter {
    @Override
    public String write() {
        return """
                                
                ****************************
                ***        Oltás         ***
                ****************************
                """;
    }
}
