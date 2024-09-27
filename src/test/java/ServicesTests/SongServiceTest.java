package ServicesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.entities.Song;
import org.spotify.enums.Genre;
import org.spotify.enums.TypeOfSong;
import org.spotify.services.SongService;

public class SongServiceTest {
    Song song;
    SongService songService;
    @BeforeEach
    public void setUp() {
        song = new Song();
        songService = new SongService();
    }
    @Test
    public void testSaveSongAndFindById() {
        song.setGenre(Genre.HipHopRap);
        song.setFilePath("ascewwc");
        song.setName("sadcvwevw");
        song.setTypeOfSong(TypeOfSong.Remake);
        song.setGenre(Genre.HipHopRap);
        song.setDuration(1234);

        songService.save(song);

        Song findSongById = songService.findSongById(song.getSong_id());
        Assertions.assertEquals(song, findSongById);
    }
    @Test
    public void testDeleteSong() {
        song.setGenre(Genre.HipHopRap);
        song.setFilePath("acwacqw");
        song.setName("qwcwqcqwc");
        song.setTypeOfSong(TypeOfSong.Remake);
        song.setGenre(Genre.HipHopRap);
        song.setDuration(1234);

        songService.save(song);

        songService.delete(song);

        Assertions.assertNull(songService.findSongById(song.getSong_id()));
    }
    @Test
    public void testDeleteSongById() {
        song.setGenre(Genre.HipHopRap);
        song.setFilePath("acwacqw");
        song.setName("qwcwqcqwc");
        song.setTypeOfSong(TypeOfSong.Remake);
        song.setGenre(Genre.HipHopRap);
        song.setDuration(1234);

        songService.save(song);

        songService.deleteById(song.getSong_id());

        Assertions.assertNull(songService.findSongById(song.getSong_id()));
    }
}
