package org.spotify.operations;

import org.spotify.db.dao.SongDao;
import org.spotify.entities.Performer;
import org.spotify.enums.Genre;
import org.spotify.entities.Song;
import org.spotify.enums.TypeOfSong;
import org.spotify.services.PerformerService;
import org.spotify.services.SongService;

import java.util.Arrays;
import java.util.Scanner;

public class AddSong {
    private final SongService songService = new SongService();
    public final PerformerService performerService = new PerformerService();

    public Song add(Song song) {
        return getSong(song);
    }

    public Song add() {
        Song song = new Song();
        return getSong(song);
    }

    private Song getSong(Song song) {
        Scanner scanner = new Scanner(System.in);
        TypeOfSong[] typeOfSongs = TypeOfSong.values();
        Genre[] genres = Genre.values();

        System.out.print("Input Performer Name: ");
        String performerName = scanner.nextLine();
        Performer performer = performerService
                .findByName(performerName);

        song.setPerformer(performer);

        System.out.print("Enter Song Name: ");
        String name = scanner.nextLine();
        song.setName(name);
        System.out.print("All type of song:");
        System.out.println(Arrays.toString(typeOfSongs));

        System.out.print("Enter the type of song: ");
        TypeOfSong typeOfSong = TypeOfSong.valueOf(scanner.nextLine());
        song.setTypeOfSong(typeOfSong);

        System.out.print("Duration: ");
        int duration = scanner.nextInt();
        song.setDuration(duration);

        scanner.nextLine();

        System.out.print("Enter path: ");
        String path = scanner.nextLine();
        song.setFilePath(path);

        System.out.print("All Genre: ");
        System.out.print(Arrays.toString(genres) + "\n");

        System.out.print("Enter song genre: ");
        Genre genre = Genre.valueOf(scanner.nextLine());
        song.setGenre(genre);

        songService.save(song);

        return song;
    }
}
