package ServicesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.entities.MusicCollection;
import org.spotify.enums.TypeOfMusicCollection;
import org.spotify.services.MusicCollectionService;

import java.time.LocalDate;

public class MusicCollectionServiceTest {
    MusicCollection musicCollection;
    MusicCollectionService musicCollectionService;
    @BeforeEach
    public void setUp() {
        musicCollection = new MusicCollection();
        musicCollectionService = new MusicCollectionService();
    }
    @Test
    public void testSaveMusicCollection() {
        musicCollection.setTypeOfCollection(TypeOfMusicCollection.EP);
        musicCollection.setName("JJ123");
        musicCollection.setReleaseDate(LocalDate.now());

        musicCollectionService.save(musicCollection);

        MusicCollection find = musicCollectionService
                .findById(musicCollection.getMusic_collection_id());

        Assertions.assertNotNull(find);
        Assertions.assertEquals(musicCollection.getMusic_collection_id(), find.getMusic_collection_id());
        Assertions.assertEquals(musicCollection.getName(), find.getName());
        Assertions.assertEquals(musicCollection.getReleaseDate(), find.getReleaseDate());
        Assertions.assertEquals(musicCollection.getTypeOfCollection(), find.getTypeOfCollection());
    }
//    @Test
//    public void testDeleteMusicCollection() {
//        musicCollection.setTypeOfCollection(TypeOfMusicCollection.EP);
//        musicCollection.setName("JJ123");
//        musicCollection.setReleaseDate(LocalDate.now());
//
//        musicCollectionService.save(musicCollection);
//
//        Assertions.assertNotNull(musicCollectionService.findById(musicCollection.getMusic_collection_id()));
//
//        musicCollectionService.delete(musicCollection);
//
//        Assertions.assertNull(musicCollectionService.findById(musicCollection.getMusic_collection_id()));
//    }
//    @Test
//    public void testDeleteMusicCollectionById() {
//        musicCollection.setTypeOfCollection(TypeOfMusicCollection.EP);
//        musicCollection.setName("JJ123");
//        musicCollection.setReleaseDate(LocalDate.now());
//
//        musicCollectionService.save(musicCollection);
//
//        Assertions.assertNotNull(musicCollectionService.findById(musicCollection.getMusic_collection_id()));
//
//        musicCollectionService.delete(musicCollection);
//
//        Assertions.assertNull(musicCollectionService.findById(musicCollection.getMusic_collection_id()));
//    }
}
