package EntitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.entities.MusicCollection;
import org.spotify.entities.Performer;
import org.spotify.entities.Song;
import org.spotify.enums.Genre;
import org.spotify.enums.TypeOfMusicCollection;
import org.spotify.enums.TypeOfSong;

import java.time.LocalDate;
import java.util.List;

public class PerformerEntitiesTests {

    private Performer performer;

    @BeforeEach
    public void setUp() {
        performer = new Performer();
    }

    @Test
    public void shouldSetAndGetPerformerName() {
        performer.setName("Test Name 1");
        Assertions.assertEquals("Test Name 1", performer.getName());
    }

    @Test
    public void shouldSetAndGetPerformerGenre() {
        performer.setGenre(Genre.HipHopRap);
        Assertions.assertEquals(Genre.HipHopRap, performer.getGenre());
    }

    @Test
    public void shouldSetAndGetPerformerSongs() {
        Song song = createTestSong();
        List<Song> songs = List.of(song);

        performer.setSongs(songs);

        Assertions.assertEquals(song, performer.getSongs().get(0));
    }

    @Test
    public void shouldSetAndGetMusicCollectionForPerformer() {
        Song song = createTestSong();
        MusicCollection musicCollection = createTestMusicCollection(song);
        List<MusicCollection> musicCollections = List.of(musicCollection);

        performer.setMusicCollection(musicCollections);

        Assertions.assertEquals(musicCollection, performer.getMusicCollection().get(0));
    }

    @Test
    public void shouldHaveDefaultValues() {
        Assertions.assertNull(performer.getName(),
                "Default name should be null");
        Assertions.assertNull(performer.getGenre(),
                "Default genre should be null");
        Assertions.assertTrue(performer.getSongs().isEmpty(),
                "Default songs list should be empty");
        Assertions.assertTrue(performer.getMusicCollection().isEmpty(),
                "Default music collection list should be empty");
    }

    @Test
    public void shouldHandleNullSongsList() {
        performer.setSongs(null);
        Assertions.assertNull(performer.getSongs(), "Songs list should allow null values");
    }

    @Test
    public void shouldHandleNullMusicCollection() {
        performer.setMusicCollection(null);
        Assertions.assertNull(performer.getMusicCollection(), "Music collection list should allow null values");
    }

    private Song createTestSong() {
        Song song = new Song();
        song.setName("Test Song Name 1");
        song.setPerformer(performer);
        song.setTypeOfSong(TypeOfSong.DJSet);
        song.setDuration(176);
        song.setGenre(Genre.HipHopRap);
        song.setFilePath("Test File Path 1");
        return song;
    }

    private MusicCollection createTestMusicCollection(Song song) {
        MusicCollection musicCollection = new MusicCollection();
        musicCollection.setName("Test Music Collection Name 1");
        musicCollection.setReleaseDate(LocalDate.now());
        musicCollection.setPerformer(performer);
        musicCollection.setTypeOfCollection(TypeOfMusicCollection.EP);
        musicCollection.setSong(List.of(song));
        return musicCollection;
    }
}
