package immutable.satellite;

public class Satellite {
    private CelestialCoordinates destinationCoordinates;
    private String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }

        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        destinationCoordinates = new CelestialCoordinates(destinationCoordinates.getX() + diff.getX(),
                destinationCoordinates.getY() + diff.getY(), destinationCoordinates.getZ() + diff.getZ()
        );
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(registerIdent);
        str.append(": ");
        str.append(destinationCoordinates.toString());

        return str.toString();
    }
}
