package DAOTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.db.dao.MusicCollectionDao;
import org.spotify.db.dao.PerformerDao;
import org.spotify.db.dao.SongDao;
import org.spotify.entities.MusicCollection;
import org.spotify.entities.Performer;
import org.spotify.entities.Song;
import org.spotify.enums.TypeOfMusicCollection;

import java.time.LocalDate;

public class MusicCollectionDAOTest {
    MusicCollection musicCollection;
    MusicCollectionDao musicCollectionDao;
    Performer performer;
    PerformerDao performerDao;
    Song song;
    SongDao songDao;
    @BeforeEach
    public void setUp() {
        musicCollection = new MusicCollection();
        musicCollectionDao = new MusicCollectionDao();
        performer = new Performer();
        performerDao = new PerformerDao();
        song = new Song();
        songDao = new SongDao();
    }
    @Test
    public void testSaveMusicCollection() {
        musicCollection.setTypeOfCollection(TypeOfMusicCollection.EP);
        musicCollection.setName("BB");
        musicCollection.setReleaseDate(LocalDate.now());
        musicCollectionDao.save(musicCollection);

        MusicCollection find = musicCollectionDao
                .findById(musicCollection.getMusic_collection_id());
        Assertions.assertEquals(musicCollection.getMusic_collection_id(), find.getMusic_collection_id());
        Assertions.assertEquals(musicCollection.getName(), find.getName());
        Assertions.assertEquals(musicCollection.getReleaseDate(), find.getReleaseDate());
        Assertions.assertEquals(TypeOfMusicCollection.EP, find.getTypeOfCollection());
    }
}
