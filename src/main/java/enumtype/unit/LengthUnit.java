package enumtype.unit;

import java.math.BigDecimal;

public enum LengthUnit {
    MM(true,1 ), CM(true, 10), M(true, 1000), YD(false, 914.4),
    FT(false,304.8), IN(false, 25.4);

    private final boolean isSi;
    private final double inMillimeter;

    LengthUnit(boolean isSi, double inMillimeter) {
        this.isSi = isSi;
        this.inMillimeter = inMillimeter;
    }

    public boolean isSi() {
        return isSi;
    }

    public double getInMillimeter() {
        return inMillimeter;
    }
}
