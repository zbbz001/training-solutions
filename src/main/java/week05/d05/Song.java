package week05.d05;

public class Song {
    private String name;
    private long lengthInSeconds;
    private String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;

        new Validator().songValidator(this);
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Song: ");
        sb.append(artist);
        sb.append(": ");
        sb.append(name);
        sb.append(" (");
        sb.append(lengthInSeconds);
        sb.append("sec)");

        return sb.toString();
    }
}