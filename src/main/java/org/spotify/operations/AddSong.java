package org.spotify.operations;

import org.spotify.db.dao.SongDao;
import org.spotify.enums.Genre;
import org.spotify.entities.Song;
import org.spotify.enums.TypeOfSong;
import org.spotify.validate.PerformerValidate;

import java.util.Arrays;
import java.util.Scanner;

public class AddSong {
    private final SongDao songDao = new SongDao();
    private final PerformerValidate performerValidate = new PerformerValidate();

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

        System.out.print("Input name: ");
        String name = scanner.nextLine();
        performerValidate.validatePerformer(name);
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

        songDao.saveSong(song);

        return song;
    }
}
