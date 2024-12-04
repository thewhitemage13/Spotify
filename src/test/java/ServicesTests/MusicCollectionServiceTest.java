package ServicesTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.spotify.db.dao.Repository;
import org.spotify.entities.MusicCollection;
import org.spotify.services.MusicCollectionService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MusicCollectionServiceTest {
    @Mock
    private Repository<MusicCollection> musicCollectionRepository;
    @InjectMocks
    private MusicCollectionService musicCollectionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSaveMusicCollection() {
        MusicCollection musicCollection = new MusicCollection();
        musicCollectionService.save(musicCollection);
        verify(musicCollectionRepository, times(1)).save(musicCollection);
    }

    @Test
    public void shouldUpdateMusicCollection() {
        MusicCollection musicCollection = new MusicCollection();
        musicCollectionService.update(musicCollection);
        verify(musicCollectionRepository, times(1)).update(musicCollection);
    }

    @Test
    public void shouldDeleteMusicCollectionByIdWhenExists() {
        Long musicCollectionId = 1L;
        MusicCollection musicCollection = new MusicCollection();
        when(musicCollectionRepository.findById(musicCollectionId)).thenReturn(musicCollection);
        musicCollectionService.delete(musicCollectionId);
        verify(musicCollectionRepository, times(1)).delete(musicCollection);
    }

    @Test
    public void shouldNotDeleteMusicCollectionIfNotFound() {
        Long musicCollectionId = 1L;
        when(musicCollectionRepository.findById(musicCollectionId)).thenReturn(null);
        musicCollectionService.delete(musicCollectionId);
        verify(musicCollectionRepository, never()).delete(any(MusicCollection.class));
    }

    @Test
    public void shouldFindAllPerformers() {
        List<MusicCollection> musicCollections = Arrays.asList(new MusicCollection(), new MusicCollection());
        when(musicCollectionRepository.findAll()).thenReturn(musicCollections);

        List<MusicCollection> result = musicCollectionService.findAll();

        assertEquals(musicCollections, result);
        verify(musicCollectionRepository, times(1)).findAll();
    }

    @Test
    void shouldFindPerformerById() {
        Long musicCollectionId = 1L;
        MusicCollection musicCollection = new MusicCollection();
        when(musicCollectionRepository.findById(musicCollectionId)).thenReturn(musicCollection);

        MusicCollection result = musicCollectionService.findById(musicCollectionId);

        assertEquals(musicCollection, result);
        verify(musicCollectionRepository, times(1)).findById(musicCollectionId);
    }
}
