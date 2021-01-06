package exam02.photo;

public class Photo implements Qualified {
    private String name;
    private Quality quality;

    public Photo(String name) {
        this(name, Quality.NO_STAR);
    }

    public Photo(String name, Quality quality) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("The name cannot be empty!");
        }

        this.name = name;
        this.quality = quality;
    }

    @Override
    public Quality getQuality() {
        return quality;
    }

    @Override
    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}