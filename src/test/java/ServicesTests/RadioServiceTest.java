package ServicesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.entities.Radio;
import org.spotify.services.RadioService;

public class RadioServiceTest {
    Radio radio;
    RadioService radioService;
    @BeforeEach
    public void setUp() {
        radio = new Radio();
        radioService = new RadioService();
    }
    @Test
    public void testFindRadioByIdAndSave() {
        radio.setRadioUrl("sdoijvwiev");
        radio.setCountry("Ukraine");
        radio.setCity("Odessa");
        radio.setRadioName("FSXS");
        radioService.save(radio);

        Radio find = radioService.findById(radio.getRadioId());
        Assertions.assertEquals(radio.getRadioUrl(), find.getRadioUrl());
        Assertions.assertEquals(radio.getCountry(), find.getCountry());
        Assertions.assertEquals(radio.getCity(), find.getCity());
        Assertions.assertEquals(radio.getRadioName(), find.getRadioName());
    }
    @Test
    public void testDeleteRadioById() {
        radio.setRadioUrl("acwcqwqw");
        radio.setCountry("Ukraine");
        radio.setCity("Odessa");
        radio.setRadioName("wqcqw");
        radioService.save(radio);

        radioService.deleteById(radio.getRadioId());

        Radio find = radioService.findById(radio.getRadioId());
        Assertions.assertNull(find);
    }
}
