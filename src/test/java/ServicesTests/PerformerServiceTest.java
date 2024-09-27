package ServicesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.entities.Performer;
import org.spotify.enums.Genre;
import org.spotify.services.PerformerService;


public class PerformerServiceTest {
    Performer performer;
    PerformerService performerService;
    @BeforeEach
    public void setUp() {
        performer = new Performer();
        performerService = new PerformerService();
    }
    @Test
    public void testSavePerformer() {
        performer.setName("Alex");
        performer.setGenre(Genre.HipHopRap);
        performerService.save(performer);

        Performer find = performerService.findByName("Alex");
        Assertions.assertEquals("Alex", find.getName());
        Assertions.assertEquals(Genre.HipHopRap, find.getGenre());
    }
    @Test
    public void testDeletePerformer() {
        performer.setName("Alex");
        performer.setGenre(Genre.HipHopRap);
        performerService.save(performer);

        performerService.delete(performer);

        Performer find = performerService.findByName("Alex");
        Assertions.assertNull(find);
    }
    @Test
    public void testDeletePerformerByName() {
        performer.setName("Alex");
        performer.setGenre(Genre.HipHopRap);
        performerService.save(performer);

        performerService.deleteByName(performer.getName());

        Performer find = performerService.findByName("Alex");
        Assertions.assertNull(find);
    }
}
