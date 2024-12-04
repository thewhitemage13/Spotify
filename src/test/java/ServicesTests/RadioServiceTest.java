package ServicesTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.spotify.db.dao.Repository;
import org.spotify.entities.Radio;
import org.spotify.services.RadioService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RadioServiceTest {
    @Mock
    private Repository<Radio> radioRepository;
    @InjectMocks
    private RadioService radioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSaveRadio() {
        Radio radio = new Radio();
        radioService.save(radio);
        verify(radioRepository, times(1)).save(radio);
    }

    @Test
    public void shouldUpdateRadio() {
        Radio radio = new Radio();
        radioService.update(radio);
        verify(radioRepository, times(1)).update(radio);
    }

    @Test
    public void shouldDeleteRadioByIdWhenExists() {
        Long radioId = 1L;
        Radio radio = new Radio();
        when(radioRepository.findById(radioId)).thenReturn(radio);
        radioService.delete(radioId);
        verify(radioRepository, times(1)).delete(radio);
    }

    @Test
    public void shouldNotDeleteRadioIfNotFound() {
        Long radioId = 1L;
        when(radioRepository.findById(radioId)).thenReturn(null);
        radioService.delete(radioId);
        verify(radioRepository, never()).delete(any(Radio.class));
    }

    @Test
    void shouldFindAllPerformers() {
        List<Radio> radios = Arrays.asList(new Radio(), new Radio());
        when(radioRepository.findAll()).thenReturn(radios);

        List<Radio> result = radioService.findAll();

        assertEquals(radios, result);
        verify(radioRepository, times(1)).findAll();
    }

    @Test
    void shouldFindPerformerById() {
        Long radioId = 1L;
        Radio radio = new Radio();
        when(radioRepository.findById(radioId)).thenReturn(radio);

        Radio result = radioService.findById(radioId);

        assertEquals(radio, result);
        verify(radioRepository, times(1)).findById(radioId);
    }
}
