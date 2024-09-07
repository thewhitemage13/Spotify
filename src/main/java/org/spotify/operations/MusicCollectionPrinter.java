package org.spotify.operations;


import org.spotify.entities.MusicCollection;
import org.spotify.services.MusicCollectionService;

import java.util.Scanner;

public class MusicCollectionPrinter {
    private final Scanner scanner = new Scanner(System.in);
    private final MusicCollectionService musicCollectionValidate = new MusicCollectionService();

    public void print() {
        System.out.print("Enter Music Collection Id: ");
        Long musicCollectionId = scanner.nextLong();
        MusicCollection musicCollection = musicCollectionValidate.findByMusicCollectionId(musicCollectionId);

        System.out.println("Name: " + musicCollection.getName());
        System.out.println("Type of collection: " + musicCollection.getTypeOfCollection());
        System.out.println("Performer: " + musicCollection.getPerformer());
        System.out.println("Date: " + musicCollection.getReleaseDate());
        for (int i = 0; i < musicCollection.getSong().size(); i++) {
            System.out.println(i + 1 + ")" + musicCollection.getSong().get(i).toString());
        }
    }
}
