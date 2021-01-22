package week12d02;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;

public class Fence implements Comparable<Fence> {
    private int width;
    private String color;
    private int houseNumber;

    public Fence(int width, String color) {
        this.width = width;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public int compareTo(@NotNull Fence o) {
        return width - o.getWidth();
    }

    @Override
    public String toString() {
        return "Fence{" +
                "width=" + width +
                ", color='" + color + '\'' +
                '}';
    }
}
