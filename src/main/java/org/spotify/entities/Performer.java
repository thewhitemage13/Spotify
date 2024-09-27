package org.spotify.entities;

import lombok.*;
import org.spotify.enums.Genre;

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
public class Performer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long performer_id;
    @Column(name = "performer_name")
    private String name;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @OneToMany(mappedBy = "performer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MusicCollection> musicCollection = new ArrayList<>();

    @OneToMany(mappedBy = "performer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs = new ArrayList<>();

    public void add(MusicCollection musicCollection) {
        musicCollection.setPerformer(this);
        this.musicCollection.add(musicCollection);
    }

    public void remove(MusicCollection musicCollection) {
        musicCollection.setPerformer(null);
        this.musicCollection.remove(musicCollection);
    }

    public void add(Song song) {
        song.setPerformer(this);
        this.songs.add(song);
    }

    public void remove(Song song) {
        song.setPerformer(null);
        this.songs.remove(song);
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
                "performer_id=" + performer_id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", musicCollection=" + musicCollection +
                ", songs=" + songs +
                '}';
    }
}
