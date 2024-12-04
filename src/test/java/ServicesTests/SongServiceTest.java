package ServicesTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.spotify.db.dao.Repository;
import org.spotify.entities.Song;
import org.spotify.services.SongService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SongServiceTest {
    @Mock
    Repository<Song> songRepository;
    @InjectMocks
    SongService songService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSaveSong() {
        Song song = new Song();
        songService.save(song);
        verify(songRepository, times(1)).save(song);
    }

    @Test
    void shouldUpdateSong() {
        Song song = new Song();
        songService.update(song);
        verify(songRepository, times(1)).update(song);
    }

    @Test
    void shouldDeleteSongByIdWhenExists() {
        Long songId = 1L;
        Song song = new Song();
        when(songRepository.findById(songId)).thenReturn(song);
        songService.delete(songId);
        verify(songRepository, times(1)).delete(song);
    }

    @Test
    void shouldNotDeletePerformerIfNotFound() {
        Long songId = 1L;
        when(songRepository.findById(songId)).thenReturn(null);

        songService.delete(songId);

        verify(songRepository, never()).delete(any(Song.class));
    }

    @Test
    void shouldFindAllSongs() {
        List<Song> performers = Arrays.asList(new Song(), new Song());
        when(songRepository.findAll()).thenReturn(performers);

        List<Song> result = songService.findAll();

        assertEquals(performers, result);
        verify(songRepository, times(1)).findAll();
    }

    @Test
    void shouldFindSongById() {
        Long performerId = 1L;
        Song song = new Song();
        when(songRepository.findById(performerId)).thenReturn(song);

        Song result = songService.findById(performerId);

        assertEquals(song, result);
        verify(songRepository, times(1)).findById(performerId);
    }
}
