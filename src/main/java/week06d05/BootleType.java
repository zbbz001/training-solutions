package week06d05;

public enum BootleType {
    GLASS_BOTTLE(1000), PET_BOTTLE(750);

    private int maximumAmount;

    BootleType(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }
}
