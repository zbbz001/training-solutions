package typeconversion.whichtype;

public enum Type {
    BYTE(Byte.MIN_VALUE, Byte.MAX_VALUE), SHORT(Short.MIN_VALUE, Short.MAX_VALUE), INT(Integer.MIN_VALUE, Integer.MAX_VALUE),
    LONG(Long.MIN_VALUE, Long.MAX_VALUE);

    private final long minValue;
    private final long maxValue;

    Type(long minValue, long maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public long getMinValue() {
        return minValue;
    }

    public long getMaxValue() {
        return maxValue;
    }
}
