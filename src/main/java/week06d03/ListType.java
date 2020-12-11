package week06d03;

public enum ListType {
    GROWING(true, false),
    DECREASING (false, true),
    OTHER (false, false);

    private boolean isGrowing;
    private boolean isDecreasing;

    ListType(boolean isGrowing, boolean isDecreasing) {
        this.isGrowing = isGrowing;
        this.isDecreasing = isDecreasing;
    }

    public boolean isGrowing() {
        return isGrowing;
    }

    public boolean isDecreasing() {
        return isDecreasing;
    }
}
