package enumtype.unit;

import java.math.BigDecimal;

public class UnitConverterMain {

    public static void main(String[] args) {
        UnitConverter unitConverter = new UnitConverter();

        System.out.println(unitConverter.convert(new BigDecimal(2.54), LengthUnit.CM, LengthUnit.IN));
        System.out.println(unitConverter.siUnits());
    }
}
