package org.spotify.operations;

import org.spotify.entities.Performer;
import org.spotify.services.PerformerService;

import java.util.Scanner;

public class PerformerPrinter {
    private final Scanner scanner = new Scanner(System.in);
    private final PerformerService performerService = new PerformerService();

    public void print() {
        System.out.println("Enter performer name: ");
        String name = scanner.nextLine();
        Performer performer = performerService
                .findByName(name);

        System.out.println("Name: " + performer.getName());
        System.out.println("Genre: " + performer.getGenre());
        System.out.print("Albums: " + performer.getMusicCollection());
    }
}
