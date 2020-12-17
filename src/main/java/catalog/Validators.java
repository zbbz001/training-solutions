package catalog;

import java.util.List;

public class Validators {

    public static boolean isEmpty(List<String> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    public static boolean isPositive(int i) {
        return i > 0;
    }
}
