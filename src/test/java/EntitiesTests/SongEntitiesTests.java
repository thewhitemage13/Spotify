package EntitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.entities.Performer;
import org.spotify.entities.Song;
import org.spotify.enums.Genre;
import org.spotify.enums.TypeOfSong;

public class SongEntitiesTests {

    private Song song;

    @BeforeEach
    public void setUp() {
        song = createTestSong();
    }

    @Test
    public void shouldSetAndGetSongName() {
        song.setName("Updated Song Name");
        Assertions.assertEquals("Updated Song Name", song.getName(),
                "Song name should be correctly set and retrieved");
    }

    @Test
    public void shouldSetAndGetSongFilePath() {
        song.setFilePath("Updated File Path");
        Assertions.assertEquals("Updated File Path", song.getFilePath(),
                "Song file path should be correctly set and retrieved");
    }

    @Test
    public void shouldSetAndGetSongGenre() {
        song.setGenre(Genre.Rock);
        Assertions.assertEquals(Genre.Rock, song.getGenre(),
                "Song genre should be correctly set and retrieved");
    }

    @Test
    public void shouldSetAndGetTypeOfSong() {
        song.setTypeOfSong(TypeOfSong.Cover);
        Assertions.assertEquals(TypeOfSong.Cover, song.getTypeOfSong(),
                "Song type should be correctly set and retrieved");
    }

    @Test
    public void shouldSetAndGetSongDuration() {
        song.setDuration(300);
        Assertions.assertEquals(300, song.getDuration(),
                "Song duration should be correctly set and retrieved");
    }

    @Test
    public void shouldSetAndGetSongPerformer() {
        Performer newPerformer = createTestPerformer();
        newPerformer.setName("New Performer");
        song.setPerformer(newPerformer);

        Assertions.assertEquals(newPerformer, song.getPerformer(),
                "Song performer should be correctly set and retrieved");
    }

    @Test
    public void shouldHandleNullPerformer() {
        song.setPerformer(null);
        Assertions.assertNull(song.getPerformer(), "Song performer should allow null values");
    }

    @Test
    public void shouldHandleNullGenre() {
        song.setGenre(null);
        Assertions.assertNull(song.getGenre(), "Song genre should allow null values");
    }

    @Test
    public void shouldHandleNullFilePath() {
        song.setFilePath(null);
        Assertions.assertNull(song.getFilePath(), "Song file path should allow null values");
    }

    private Song createTestSong() {
        Song testSong = new Song();
        testSong.setName("Test Song Name");
        testSong.setFilePath("Test File Path");
        testSong.setGenre(Genre.HipHopRap);
        testSong.setTypeOfSong(TypeOfSong.Original);
        testSong.setDuration(200);
        return testSong;
    }

    private Performer createTestPerformer() {
        Performer testPerformer = new Performer();
        testPerformer.setName("Test Performer Name");
        testPerformer.setGenre(Genre.HipHopRap);
        return testPerformer;
    }
}
