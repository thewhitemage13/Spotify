import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import org.spotify.dataBase.Util.HibernateUtil;
import org.spotify.entity.MusicCollection;
import org.spotify.entity.Performer;
import org.spotify.entity.Song;
import org.spotify.enums.Genre;
import org.spotify.enums.TypeOfSong;
import org.spotify.interfaces.TypeOfCollection;

import java.time.LocalDate;

public class SpotifyTest {
    @Test
    public void checkOneToMany() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        var song = Song.builder()
                .typeOfSong(TypeOfSong.Original)
                .genre(Genre.HipHopRap)
                .filePath("123")
                .duration(178)
                .name("52Haunted")
                .build();

        var performer = Performer.builder()
                .name("123")
                .genre(Genre.HipHopRap)
                .build();

        var musicCollection = MusicCollection.builder()
                .typeOfCollection(TypeOfCollection.EP)
                .releaseDate(LocalDate.of(2023, 12, 12))
                .name("123&123")
                .performer(performer)
                .build();

        musicCollection.getSong().add(song);

        session.save(song);
        session.save(performer);
        session.save(musicCollection);

        session.getTransaction().commit();
    }
}
