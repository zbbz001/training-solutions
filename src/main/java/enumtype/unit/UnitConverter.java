package enumtype.unit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter {

    public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target) {
        BigDecimal result = length.multiply(new BigDecimal(source.getInMillimeter()))
                .divide(new BigDecimal(target.getInMillimeter()), 4, RoundingMode.HALF_UP);

        return result;
    }

    public List<LengthUnit> siUnits() {
        List<LengthUnit> siUnits = new ArrayList<>();

        for (LengthUnit siUnit : LengthUnit.values()) {
            if (siUnit.isSi()) {
                siUnits.add(siUnit);
            }
        }

        return siUnits;
    }

}
