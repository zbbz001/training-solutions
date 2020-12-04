package week06d05;

public class Bottle {
    private BootleType type;
    private int filledUnit;

    public Bottle(BootleType type) {
        this.type = type;
    }

    public void fill(int fillAmount) {
        if(type.getMaximumAmount() < filledUnit + fillAmount) {
            throw new RuntimeException("The bottle is full!");
        }

        filledUnit += fillAmount;
    }

    public static Bottle of(BootleType bootleType) {
        return new Bottle(bootleType);
    }

    public int getFilledUnit() {
        return filledUnit;
    }
}
