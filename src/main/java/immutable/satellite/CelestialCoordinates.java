package immutable.satellite;

public class CelestialCoordinates {
    final int x;
    final int y;
    final int z;

    public CelestialCoordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("CelestialCoordinates: x=");
        str.append(x);
        str.append(", y=");
        str.append(y);
        str.append(", z=");
        str.append(z);

        return str.toString();
    }
}
