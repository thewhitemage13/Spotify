package org.spotify.entities;

import lombok.*;
import org.spotify.enums.TypeOfMusicCollection;

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
public class MusicCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long music_collection_id;
    @Column(name = "music_collection_name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_collection")
    private TypeOfMusicCollection typeOfCollection;
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

    public void add(Song song) {
        this.song.add(song);
    }

    public void add(List<Song> song) {
        this.song.addAll(song);
    }

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
    public MusicCollection(Long music_collection_id, String name, TypeOfMusicCollection typeOfCollection, LocalDate releaseDate, Performer performer, List<Song> songs) {
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
