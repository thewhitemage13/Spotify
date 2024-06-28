package org.spotify.entity;

import lombok.*;
import org.spotify.interfaces.AddSong;
import org.spotify.interfaces.SongCollectionManager;
import org.spotify.interfaces.TypeOfCollection;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "music_collections")
// Класс музыкальной коллекции
public class MusicCollection implements SongCollectionManager<Song>, AddSong<Song> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long music_collection_id;
    @Column(name = "music_collection_name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_collection")
    private TypeOfCollection typeOfCollection;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @ManyToOne
    @JoinColumn(name = "performer_id")
    private Performer performer;
    @ManyToMany
    @JoinTable(
            name = "music_collection_songs",
            joinColumns = @JoinColumn(name = "music_collection_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> song = new ArrayList<>();

    @Override
    public void add(Song song) {
        this.song.add(song);
    }

    @Override
    public void add(List<Song> song) {
        this.song.addAll(song);
    }

    @Override
    public void remove(Song song) {
        this.song.remove(song);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicCollection that = (MusicCollection) o;
        return Objects.equals(name, that.name) && typeOfCollection == that.typeOfCollection && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(performer, that.performer) && Objects.equals(song, that.song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, typeOfCollection, releaseDate, performer, song);
    }

    @Builder
    public MusicCollection(Long music_collection_id, String name, TypeOfCollection typeOfCollection, LocalDate releaseDate, Performer performer, List<Song> songs) {
        this.music_collection_id = music_collection_id;
        this.name = name;
        this.typeOfCollection = typeOfCollection;
        this.releaseDate = releaseDate;
        this.performer = performer;
        this.song = songs != null ? songs : new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return "MusicCollection{" +
                "name='" + name + '\'' +
                ", typeOfCollection=" + typeOfCollection +
                ", releaseDate=" + releaseDate +
                ", song=" + song +
                '}';
    }

}
