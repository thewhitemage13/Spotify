package PerformerTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.entities.Radio;

public class RadioTest {
    Radio radio;
    @BeforeEach
    public void setUp() {
        radio = new Radio();
    }
    @Test
    public void testSetAndGetCity() {
        radio.setCity("San Francisco");
        Assertions.assertEquals("San Francisco", radio.getCity());
    }
    @Test
    public void testSetAndGetCountry() {
        radio.setCountry("US");
        Assertions.assertEquals("US", radio.getCountry());
    }
    @Test
    public void testSetAndGetRadioName() {
        radio.setRadioName("San Francisco");
        Assertions.assertEquals("San Francisco", radio.getRadioName());
    }
    @Test
    public void testSetAndGetRadioUrl() {
        radio.setRadioUrl("http://www.spotify.com");
        Assertions.assertEquals("http://www.spotify.com", radio.getRadioUrl());
    }
}
