package org.spotify.operations;

import org.spotify.services.PerformerService;

import java.util.Scanner;

public class DeletePerformer {
    private final Scanner scanner = new Scanner(System.in);
    private final PerformerService performerService = new PerformerService();

    public void delete() {
        System.out.print("Enter performer name: ");
        String name = scanner.nextLine();

        performerService.deleteByName(name);
        System.out.println("Performer deleted");
    }
}
