package covid.module.toConsole;

public class ImportMultipleHeader implements ConsoleWriter {
    @Override
    public String write() {
        return """
                                
                ****************************
                *** Tömeges regisztráció ***
                ****************************
                """;
    }
}
