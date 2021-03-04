package covid.module.toConsole;

public class RejectVaccinationHeader implements ConsoleWriter {
    @Override
    public String write() {
        return """
                                
                ****************************
                ***  Oltás meghiúsulás   ***
                ****************************
                """;
    }
}
