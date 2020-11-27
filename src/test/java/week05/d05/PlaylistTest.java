package week05.d05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    @Test
    public void testPlaylist() {
        List<Song> songList = new ArrayList<>();
        songList.add(new Song("Smells Like Teen Spirit", 277, "Nirvana"));
        songList.add(new Song("Highway Star", 205, "Deep Purple"));
        songList.add(new Song("Don't Look Back in Anger", 210, "Oasis"));

        Playlist playlist = new Playlist(songList);

        assertEquals("[Song: Nirvana: Smells Like Teen Spirit (277sec)]", playlist.findByLengthGreaterThan(4).toString());
        assertEquals("[]", playlist.findByLengthGreaterThan(40).toString());
    }
}