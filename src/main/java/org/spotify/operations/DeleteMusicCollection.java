package org.spotify.operations;

import org.spotify.db.dao.MusicCollectionDao;

import java.util.Scanner;

public class DeleteMusicCollection {
    Scanner scanner = new Scanner(System.in);
    MusicCollectionDao musicCollectionDao = new MusicCollectionDao();

    public void delete() {
        System.out.print("Enter music collection id: ");
        Long id = scanner.nextLong();
        musicCollectionDao.deleteMusicCollectionById(id);
        System.out.println("Music collection deleted");
    }
}
