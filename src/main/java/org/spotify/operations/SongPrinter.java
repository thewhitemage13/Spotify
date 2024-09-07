package org.spotify.operations;

import org.spotify.entities.Song;
import org.spotify.services.SongService;

import java.util.Scanner;

public class SongPrinter {
    private final Scanner scanner = new Scanner(System.in);
    private final SongService songValidate = new SongService();

    public void print() {
        System.out.println("Enter song id: ");
        Long songId = scanner.nextLong();
        Song song = songValidate.findSongById(songId);
        System.out.println("Name: " + song.getName());
        System.out.println("Type Of Song: " + song.getTypeOfSong());
        System.out.println("Duration: " + song.getDuration() + "sec.");
        System.out.println("Genre: " + song.getGenre());
    }
}
