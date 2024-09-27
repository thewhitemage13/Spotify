package DAOTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.db.dao.PerformerDao;
import org.spotify.db.dao.SongDao;
import org.spotify.entities.Performer;
import org.spotify.enums.Genre;

import static org.junit.jupiter.api.Assertions.*;

public class PerformerDAOTest {
    Performer performer;
    PerformerDao performerDao;
    SongDao songDao;
    @BeforeEach
    public void setUp() {
        performer = new Performer();
        performerDao = new PerformerDao();
        songDao = new SongDao();
    }
    @Test
    public void testSavePerformer() {
        performer.setGenre(Genre.HipHopRap);
        performer.setName("Mc Kissulya");
        performerDao.save(performer);
        Performer findPerformer = performerDao.findByName(performer.getName());

        assertNotNull(findPerformer);
        assertEquals(performer.getName(), findPerformer.getName());
        assertEquals(performer.getGenre(), findPerformer.getGenre());
    }
    @Test
    public void testFindPerformerByName() {
        performer.setGenre(Genre.Indie);
        performer.setName("Obladaet");
        performerDao.save(performer);
        Performer findPerformer = performerDao.findByName(performer.getName());

        assertNotNull(findPerformer);
        assertEquals(performer.getName(), findPerformer.getName());
        assertEquals(performer.getGenre(), findPerformer.getGenre());
    }
    @Test
    public void testDeletePerformerByName() {
        performer.setGenre(Genre.HipHopRap);
        performer.setName("ALBLAK 52");
        performerDao.save(performer);
        performerDao.deleteByName(performer.getName());
        Performer findPerformer = performerDao.findByName(performer.getName());

        assertNull(findPerformer);
    }
}
