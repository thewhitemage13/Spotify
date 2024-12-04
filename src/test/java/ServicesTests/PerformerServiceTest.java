package ServicesTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.spotify.db.dao.Repository;
import org.spotify.entities.Performer;
import org.spotify.services.PerformerService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PerformerServiceTest {
    @Mock
    private Repository<Performer> performerRepo;
    @InjectMocks
    private PerformerService performerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSavePerformer() {
        Performer performer = new Performer();
        performerService.save(performer);
        verify(performerRepo, times(1)).save(performer);
    }

    @Test
    void shouldUpdatePerformer() {
        Performer performer = new Performer();
        performerService.update(performer);
        verify(performerRepo, times(1)).update(performer);
    }

    @Test
    void shouldDeletePerformerByIdWhenExists() {
        Long performerId = 1L;
        Performer performer = new Performer();
        when(performerRepo.findById(performerId)).thenReturn(performer);

        performerService.delete(performerId);

        verify(performerRepo, times(1)).delete(performer);
    }

    @Test
    void shouldNotDeletePerformerIfNotFound() {
        Long performerId = 1L;
        when(performerRepo.findById(performerId)).thenReturn(null);

        performerService.delete(performerId);

        verify(performerRepo, never()).delete(any(Performer.class));
    }

    @Test
    void shouldFindAllPerformers() {
        List<Performer> performers = Arrays.asList(new Performer(), new Performer());
        when(performerRepo.findAll()).thenReturn(performers);

        List<Performer> result = performerService.findAll();

        assertEquals(performers, result);
        verify(performerRepo, times(1)).findAll();
    }

    @Test
    void shouldFindPerformerById() {
        Long performerId = 1L;
        Performer performer = new Performer();
        when(performerRepo.findById(performerId)).thenReturn(performer);

        Performer result = performerService.findById(performerId);

        assertEquals(performer, result);
        verify(performerRepo, times(1)).findById(performerId);
    }
}
