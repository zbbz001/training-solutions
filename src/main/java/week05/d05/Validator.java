package week05.d05;

public class Validator {

    public void songValidator(Song song) {
        if(isEmpty(song.getName())) {
            throw new IllegalArgumentException("The song's name cannot be empty or null.");
        }

        if(isEmpty(song.getArtist())) {
            throw new IllegalArgumentException("The song's artist cannot be empty or null.");
        }

        if(!isValidSongLength(song.getLengthInSeconds())) {
            throw new IllegalArgumentException("The song's length must be greater than 0, lengthInSeconds:" + song.getLengthInSeconds());
        }
    }

    private boolean isValidSongLength(long seconds) {
        return seconds > 0;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
