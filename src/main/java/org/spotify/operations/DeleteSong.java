package org.spotify.operations;

import org.spotify.db.dao.SongDao;

import java.util.Scanner;

public class DeleteSong {
    Scanner scanner = new Scanner(System.in);
    SongDao songDao = new SongDao();

    public void delete() {
        System.out.print("Enter song id: ");
        Long id = scanner.nextLong();
        songDao.deleteSongById(id);
        System.out.println("Song deleted");
    }

}
