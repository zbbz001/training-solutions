package covid;

public enum Vaccine {
    PIF("PIFZER/BIONTECH"), MOD("MODERNA"), SZP("SZPUTNYIK V"), SIN("SINOPHARM"), AST("ASTRAZENECA/OXFORD");

    private final String name;

    Vaccine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name() + ": " + getName();
    }
}
