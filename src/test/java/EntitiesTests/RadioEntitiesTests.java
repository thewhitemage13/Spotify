package EntitiesTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.entities.Radio;

public class RadioEntitiesTests {
    Radio radio;

    @BeforeEach
    public void setUp() {
        radio = new Radio();
    }

    @Test
    public void shouldSetAndGetRadioName() {
        radio.setRadioName("Test Radio Name 1");

        Assertions.assertEquals("Test Radio Name 1", radio.getRadioName(),
                "Radio name should be correctly set and retrieved");
    }

    @Test
    public void shouldSetAndGetRadioUrl() {
        radio.setRadioUrl("Test Radio Url");

        Assertions.assertEquals("Test Radio Url", radio.getRadioUrl(),
                "Radio Url should be correctly set and retrieved");
    }

    @Test
    public void shouldSetAndGetRadioCity() {
        radio.setCity("Test Radio City");

        Assertions.assertEquals("Test Radio City", radio.getCity(),
                "Radio City should be correctly set and retrieved");
    }

    @Test
    public void shouldSetAndGetRadioCountry() {
        radio.setCountry("Test Radio Country");

        Assertions.assertEquals("Test Radio Country", radio.getCountry(),
                "Radio Country should be correctly set and retrieved");
    }
}
