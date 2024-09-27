package DAOTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.spotify.db.dao.RadioDao;
import org.spotify.entities.Radio;

import static org.junit.jupiter.api.Assertions.*;
/*JUnit 5 для DAO слоя обькта Radio*/
public class RadioDAOTest {
    Radio radio;
    RadioDao radioDao;
    @BeforeEach
    public void setUp() {
        radio = new Radio();
        radioDao = new RadioDao();
    }
    @Test
    public void testSaveRadio() {
        radio.setRadioName("1+1");
        radio.setRadioUrl("asewcw");
        radio.setCity("Kyiv");
        radio.setCountry("Ukraine");
        radioDao.save(radio);

        Radio checkRadio = radioDao
                .findById(radio.getRadioId());

        assertNotNull(checkRadio);
        assertEquals("1+1", checkRadio.getRadioName());
        assertEquals("asewcw", checkRadio.getRadioUrl());
        assertEquals("Kyiv", checkRadio.getCity());
        assertEquals("Ukraine", checkRadio.getCountry());
    }
    @Test
    public void testDeleteRadioById() {
        radio.setRadioName("1+1");
        radio.setRadioUrl("asewcw");
        radio.setCity("Kyiv");
        radio.setCountry("Ukraine");
        radioDao.save(radio);

        Radio savedRadio = radioDao.findById(radio.getRadioId());
        assertNotNull(savedRadio);

        radioDao.deleteById(radio.getRadioId());
        Radio check = radioDao.findById(radio.getRadioId());
        assertNull(check);
    }
    @Test
    public void testFindRadioById() {
        // save
        radio.setRadioName("1+1");
        radio.setRadioUrl("asewcw");
        radio.setCity("Kyiv");
        radio.setCountry("Ukraine");
        radioDao.save(radio);

        Radio check = radioDao.findById(radio.getRadioId());
        assertNotNull(check);

        assertEquals("1+1", check.getRadioName());
        assertEquals("asewcw", check.getRadioUrl());
        assertEquals("Kyiv", check.getCity());
        assertEquals("Ukraine", check.getCountry());
    }
}
