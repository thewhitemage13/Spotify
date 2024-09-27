package EntityTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.entities.MusicCollection;
import org.spotify.entities.Performer;
import org.spotify.entities.Song;
import org.spotify.enums.Genre;

import static org.junit.jupiter.api.Assertions.*;

public class PerformerTest {
    Performer performer;
    @BeforeEach
    public void setUp() {
        performer = new Performer();
    }
    @Test
    public void testSetAndGetName() {
        performer.setName("ALBLAK 52");
        assertEquals("ALBLAK 52", performer.getName());
    }
    @Test
    public void testSetAndGetGenre() {
        performer.setGenre(Genre.HipHopRap);
        assertEquals(Genre.HipHopRap, performer.getGenre());
    }
    @Test
    public void testSetAndGetSong() {
        Song song = new Song();
        performer.add(song);
        assertEquals(1, performer.getSongs().size());
    }
    @Test
    public void testRemoveSong() {
        Song song = new Song();
        performer.add(song);
        performer.remove(song);
        assertEquals(0, performer.getSongs().size());
    }
    @Test
    public void testSetAndGetAlbum() {
        MusicCollection musicCollection = new MusicCollection();
        performer.add(musicCollection);
        assertEquals(1, performer.getMusicCollection().size());
    }
    @Test
    public void testRemoveMusicCollection() {
        MusicCollection musicCollection = new MusicCollection();
        performer.add(musicCollection);
        performer.remove(musicCollection);
        assertEquals(0, performer.getMusicCollection().size());
    }
}
