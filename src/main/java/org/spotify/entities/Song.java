package org.spotify.entities;

import lombok.*;
import org.spotify.enums.Genre;
import org.spotify.enums.TypeOfSong;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long song_id;
    @Column(name = "song_name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_song")
    private TypeOfSong typeOfSong;
    @Column(name = "duration")
    private int duration;
    @Column(name = "file_path")
    private String filePath;
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;
    @ManyToOne
    @JoinColumn(name = "performer_id")
    private Performer performer;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return duration == song.duration && Objects.equals(name, song.name) && typeOfSong == song.typeOfSong && Objects.equals(filePath, song.filePath) && genre == song.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, typeOfSong, duration, filePath, genre);
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", typeOfSong=" + typeOfSong +
                ", duration=" + duration +
                ", filePath='" + filePath + '\'' +
                ", genre=" + genre +
                '}';
    }

}
