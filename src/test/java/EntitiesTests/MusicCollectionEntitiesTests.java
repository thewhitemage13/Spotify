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
import java.util.ArrayList;
import java.util.List;

public class MusicCollectionEntitiesTests {

    private MusicCollection musicCollection;

    @BeforeEach
    public void setUp() {
        musicCollection = createTestMusicCollection();
    }

    @Test
    public void shouldSetAndGetMusicCollectionName() {
        musicCollection.setName("Updated Music Collection Name");
        Assertions.assertEquals("Updated Music Collection Name", musicCollection.getName(),
                "Music collection name should be correctly set and retrieved");
    }

    @Test
    public void shouldSetAndGetTypeOfCollection() {
        musicCollection.setTypeOfCollection(TypeOfMusicCollection.Album);
        Assertions.assertEquals(TypeOfMusicCollection.Album, musicCollection.getTypeOfCollection(),
                "Music collection type should be correctly set and retrieved");
    }

    @Test
    public void shouldSetAndGetReleaseDate() {
        LocalDate today = LocalDate.now();
        musicCollection.setReleaseDate(today);
        Assertions.assertEquals(today, musicCollection.getReleaseDate(),
                "Music collection release date should be correctly set and retrieved");
    }

    @Test
    public void shouldSetAndGetMusicCollectionPerformer() {
        Performer newPerformer = createTestPerformer();
        newPerformer.setName("New Performer");

        musicCollection.setPerformer(newPerformer);
        Assertions.assertEquals(newPerformer, musicCollection.getPerformer(),
                "Music collection performer should be correctly set and retrieved");
    }

    @Test
    public void shouldSetAndGetMusicCollectionSongs() {
        List<Song> newSongList = new ArrayList<>();
        newSongList.add(createTestSong("New Song", TypeOfSong.Cover, 200, "New Path", Genre.Rock));

        musicCollection.setSong(newSongList);
        Assertions.assertEquals(newSongList, musicCollection.getSong(),
                "Music collection songs should be correctly set and retrieved");
    }

    @Test
    public void shouldHandleEmptySongList() {
        musicCollection.setSong(new ArrayList<>());
        Assertions.assertTrue(musicCollection.getSong().isEmpty(),
                "Music collection should handle an empty song list");
    }

    @Test
    public void shouldHandleNullPerformer() {
        musicCollection.setPerformer(null);
        Assertions.assertNull(musicCollection.getPerformer(),
                "Music collection performer should allow null values");
    }

    @Test
    public void shouldHandleNullSongs() {
        musicCollection.setSong(null);
        Assertions.assertNull(musicCollection.getSong(),
                "Music collection songs should allow null values");
    }

    private MusicCollection createTestMusicCollection() {
        MusicCollection collection = new MusicCollection();
        collection.setName("Test Music Collection");
        collection.setTypeOfCollection(TypeOfMusicCollection.EP);
        collection.setReleaseDate(LocalDate.now());
        collection.setPerformer(createTestPerformer());
        collection.setSong(List.of(createTestSong()));
        return collection;
    }

    private Performer createTestPerformer() {
        Performer performer = new Performer();
        performer.setName("Test Performer");
        performer.setGenre(Genre.Disco);
        return performer;
    }

    private Song createTestSong() {
        return createTestSong("Test Song", TypeOfSong.Original, 167, "Test file path", Genre.Disco);
    }

    private Song createTestSong(String name, TypeOfSong type, int duration, String filePath, Genre genre) {
        Song song = new Song();
        song.setName(name);
        song.setTypeOfSong(type);
        song.setDuration(duration);
        song.setFilePath(filePath);
        song.setGenre(genre);
        return song;
    }
}
