package org.spotify.operations;

import org.spotify.db.dao.SongDao;
import org.spotify.services.SongService;

import java.util.Scanner;

public class DeleteSong {
    private final Scanner scanner = new Scanner(System.in);
    private final SongService songService = new SongService();

    public void delete() {
        System.out.print("Enter song id: ");
        Long id = scanner.nextLong();
        songService.deleteById(id);
        System.out.println("Song deleted");
    }

}
