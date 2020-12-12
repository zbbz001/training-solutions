package ioreadwritebytes.temperatures;

public class Temperatures {
    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public double getYearAverage() {
        double sum = 0;

        for (byte temp : data) {
            sum += temp;
        }
        return sum / 365;
    }

    public double getMonthAverage() {
        double sum = 0;

        for (int i = 1; i <= 31; i++) {
            sum += data[data.length - i];
        }

        return sum / 365;
    }

    public byte[] getData() {
        return data;
    }
}
