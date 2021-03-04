package covid.module.toConsole;

public class GenerateReportByZipHeader implements ConsoleWriter {
    @Override
    public String write() {
        return """
                                
                *******************************
                *** Településenkénti riport ***
                *******************************
                """;
    }
}

