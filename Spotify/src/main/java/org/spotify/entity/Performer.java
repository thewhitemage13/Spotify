package org.spotify.entity;

import lombok.*;
import org.spotify.enums.Genre;
import org.spotify.interfaces.SongCollectionManager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "performers")
// Класс исполнителя
public class Performer implements SongCollectionManager<MusicCollection> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long performer_id;
    @Column(name = "performer_name")
    private String name;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @OneToMany(mappedBy = "performer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MusicCollection> musicCollection = new ArrayList<>();

    @Override
    public void add(MusicCollection musicCollection) {
        musicCollection.setPerformer(this);
        this.musicCollection.add(musicCollection);
    }
    @Override
    public void remove(MusicCollection musicCollection) {
        musicCollection.setPerformer(null);
        this.musicCollection.remove(musicCollection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Performer performer = (Performer) o;
        return Objects.equals(name, performer.name) && genre == performer.genre && Objects.equals(musicCollection, performer.musicCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre, musicCollection);
    }

    @Override
    public String toString() {
        return "Performer{" +
                "name='" + name + '\'' +
                ", genre=" + genre +
                ", album=" + musicCollection +
                '}';
    }
}
