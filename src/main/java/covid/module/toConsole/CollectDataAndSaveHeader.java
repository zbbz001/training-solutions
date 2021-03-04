package covid.module.toConsole;

public class CollectDataAndSaveHeader implements ConsoleWriter {
    @Override
    public String write() {
        return """
                                
                ****************************
                ***     Regisztráció     ***
                ****************************
                """;
    }
}
