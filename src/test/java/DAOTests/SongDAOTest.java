package DAOTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.db.dao.PerformerDao;
import org.spotify.db.dao.SongDao;
import org.spotify.entities.Performer;
import org.spotify.entities.Song;
import org.spotify.enums.Genre;
import org.spotify.enums.TypeOfSong;

import java.util.Optional;

public class SongDAOTest {
    SongDao songDao;
    Song song;
    Performer performer;
    PerformerDao performerDao;
    @BeforeEach
    public void setUp() {
        songDao = new SongDao();
        song = new Song();
        performerDao = new PerformerDao();
        performer = new Performer();
    }
    @Test
    public void testSaveSong() {
        performer.setName("Asss");
        performer.setGenre(Genre.HipHopRap);
        performerDao.save(performer);

        song.setTypeOfSong(TypeOfSong.Remake);
        song.setName("Street Echo");
        song.setDuration(167);
        song.setGenre(Genre.HipHopRap);
        song.setFilePath("sdcwewevwv");
        song.setPerformer(performer);
        songDao.save(song);

        Song song1 = songDao.findById(song.getSong_id());

        Assertions.assertNotNull(song1);
        Assertions.assertEquals(song.getSong_id(), song1.getSong_id());
        Assertions.assertEquals(song.getGenre(), song1.getGenre());
        Assertions.assertEquals(song.getDuration(), song1.getDuration());
        Assertions.assertEquals(song.getFilePath(), song1.getFilePath());
    }
    @Test
    public void testFindSongById() {
        performer.setName("Asss");
        performer.setGenre(Genre.HipHopRap);
        performerDao.save(performer);

        song.setTypeOfSong(TypeOfSong.Remake);
        song.setName("Street Echo");
        song.setDuration(167);
        song.setGenre(Genre.HipHopRap);
        song.setFilePath("sdcwewevwv");
        song.setPerformer(performer);
        songDao.save(song);

        Song song1 = songDao.findById(song.getSong_id());

        Assertions.assertNotNull(song1);
        Assertions.assertEquals(song.getSong_id(), song1.getSong_id());
        Assertions.assertEquals(song.getGenre(), song1.getGenre());
        Assertions.assertEquals(song.getDuration(), song1.getDuration());
        Assertions.assertEquals(song.getFilePath(), song1.getFilePath());
    }
    @Test
    public void testDeleteSongById() {
        performer.setName("Asss");
        performer.setGenre(Genre.HipHopRap);
        performerDao.save(performer);

        song.setTypeOfSong(TypeOfSong.Remake);
        song.setName("Street Echo");
        song.setDuration(167);
        song.setGenre(Genre.HipHopRap);
        song.setFilePath("sdcwewevwv");
        song.setPerformer(performer);
        songDao.save(song);

        songDao.deleteById(song.getSong_id());
        Song song1 = songDao.findById(song.getSong_id());
        Assertions.assertNull(song1);
    }
    @Test
    public void testDeleteSong() {
        performer.setName("Asss");
        performer.setGenre(Genre.HipHopRap);
        performerDao.save(performer);

        song.setTypeOfSong(TypeOfSong.Remake);
        song.setName("Street Echo");
        song.setDuration(167);
        song.setGenre(Genre.HipHopRap);
        song.setFilePath("sdcwewevwv");
        song.setPerformer(performer);
        songDao.save(song);

        songDao.deleteById(song.getSong_id());
        Song song1 = songDao.findById(song.getSong_id());
        Assertions.assertNull(song1);
    }
}
