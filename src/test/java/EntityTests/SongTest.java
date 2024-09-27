package EntityTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.entities.Performer;
import org.spotify.entities.Song;
import org.spotify.enums.Genre;
import org.spotify.enums.TypeOfSong;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTest {
    Song song;
    @BeforeEach
    public void setUp() {
        song = new Song();
    }
    @Test
    public void testSetAndGetName() {
        song.setName("Test Name");
        assertEquals("Test Name", song.getName());
    }
    @Test
    public void testSetAndGetTypeOfSong() {
        song.setTypeOfSong(TypeOfSong.DJSet);
        assertEquals(TypeOfSong.DJSet, song.getTypeOfSong());
    }
    @Test
    public void testSetAndGetDuration() {
        song.setDuration(10);
        assertEquals(10, song.getDuration());
    }
    @Test
    public void testSetAndGetFilePath() {
        song.setFilePath("TestFilePath");
        assertEquals("TestFilePath", song.getFilePath());
    }
    @Test
    public void testSetAndGetGenre() {
        song.setGenre(Genre.Disco);
        assertEquals(Genre.Disco, song.getGenre());
    }
    @Test
    public void testSetAndGetPerformer() {
        Performer performer = new Performer();
        song.setPerformer(performer);
        assertEquals(performer, song.getPerformer());
    }
}
