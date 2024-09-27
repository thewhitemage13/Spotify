package org.spotify.operations;

import org.spotify.db.dao.MusicCollectionDao;
import org.spotify.services.MusicCollectionService;

import java.util.Scanner;

public class DeleteMusicCollection {
    private final Scanner scanner = new Scanner(System.in);
    private final MusicCollectionService musicCollectionService = new MusicCollectionService();

    public void delete() {
        System.out.print("Enter music collection id: ");
        Long id = scanner.nextLong();
        musicCollectionService.deleteMusicCollectionById(id);
        System.out.println("Music collection deleted");
    }
}
