package week05.d05;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    List<Song> songList = new ArrayList<>();

    public Playlist(List<Song> songList) {
        this.songList = songList;
    }

    public List<Song> findByLengthGreaterThan(int mins) {
        List<Song> filteredSongs = new ArrayList<>();
        for(Song song:songList) {
            if(song.getLengthInSeconds() > mins * 60) {
                filteredSongs.add(song);
            }
        }

        return filteredSongs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Playlist: ");
        sb.append(songList);

        return sb.toString();
    }
}