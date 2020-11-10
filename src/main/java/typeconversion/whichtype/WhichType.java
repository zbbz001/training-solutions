package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {
    public List<Type> whichType(String s) {
        List<Type> whichType = new ArrayList<>();
        long longNumber = Long.parseLong(s);

        for(Type type:Type.values()) {
            if(type.getMinValue() < longNumber && type.getMaxValue() > longNumber) {
                whichType.add(type);
            }
        }

        return whichType;
    }



}
