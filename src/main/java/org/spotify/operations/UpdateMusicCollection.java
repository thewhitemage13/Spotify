package org.spotify.operations;

import org.spotify.entities.MusicCollection;
import org.spotify.services.MusicCollectionService;

import java.util.Scanner;

public class UpdateMusicCollection {
    private final MusicCollectionService musicCollectionService = new MusicCollectionService();
    private final Scanner scanner = new Scanner(System.in);

    public void update() {
        System.out.print("Enter Music Collection Id: ");
        Long musicCollectionId = scanner.nextLong();
        MusicCollection musicCollection = musicCollectionService
                .findById(musicCollectionId);
    }
}
