package org.spotify.operations;

import org.spotify.entities.Song;
import org.spotify.enums.Genre;
import org.spotify.enums.TypeOfSong;
import org.spotify.services.SongService;

import java.util.Arrays;
import java.util.Scanner;

public class UpdateSong {
    private final Scanner scanner = new Scanner(System.in);
    private final SongService songService = new SongService();

    public void update() {
        TypeOfSong[] typeOfSongs = TypeOfSong.values();
        Genre[] genres = Genre.values();

        System.out.print("Enter Song Id: ");
        Long songId = scanner.nextLong();
        Song song = songService.findSongById(songId);

        System.out.println("Enter Update Song Name: ");
        String updateSongName = scanner.next();
        song.setName(updateSongName);

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
    }
}
