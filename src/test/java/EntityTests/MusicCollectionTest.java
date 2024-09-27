package EntityTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.entities.MusicCollection;
import org.spotify.entities.Performer;
import org.spotify.entities.Song;
import org.spotify.enums.Genre;
import org.spotify.enums.TypeOfMusicCollection;
import org.spotify.enums.TypeOfSong;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MusicCollectionTest {
    MusicCollection musicCollection;
    @BeforeEach
    public void setUp() {
        musicCollection = new MusicCollection();
    }
    @Test
    public void testASetAndGetMusicCollectionName() {
        musicCollection.setName("Street Echo");
        assertEquals("Street Echo", musicCollection.getName());
    }
    @Test
    public void testSetAndGetTypeOfMusicCollection() {
        musicCollection.setTypeOfCollection(TypeOfMusicCollection.EP);
        assertEquals(TypeOfMusicCollection.EP, musicCollection.getTypeOfCollection());
    }
    @Test
    public void testSetAndGetReleaseDate() {
        musicCollection.setReleaseDate(LocalDate.of(2012,12,12));
        assertEquals(LocalDate.of(2012,12,12), musicCollection.getReleaseDate());
    }
    @Test
    public void testSetAndGetPerformer() {
        Performer performer = new Performer();
        musicCollection.setPerformer(performer);
        assertEquals(performer, musicCollection.getPerformer());
    }
    @Test
    public void testSetAndGetSong() {
        Song song = new Song();
        List<Song> songs = new ArrayList<>();
        song.setTypeOfSong(TypeOfSong.DJSet);
        song.setGenre(Genre.Disco);
        song.setName("Dj Khalid");
        song.setDuration(1234);
        song.setFilePath("");
        songs.add(song);
        musicCollection.setSong(songs);
        assertEquals(songs, musicCollection.getSong());
    }
}
