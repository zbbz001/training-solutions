package covid.module.toConsole;

public class Menu implements ConsoleWriter {
    @Override
    public String write() {
        return """
                                
                1. Regisztráció
                2. Tömeges regisztráció
                3. Generálás
                4. Oltás
                5. Oltás meghiúsulás
                6. Riport
                0. Kilépés

                Válasszon menüpontot!""";
    }
}
