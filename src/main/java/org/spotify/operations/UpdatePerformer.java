package org.spotify.operations;

import org.spotify.entities.Performer;
import org.spotify.enums.Genre;
import org.spotify.exceptions.NameIsBusyException;
import org.spotify.services.PerformerService;

import java.util.Arrays;
import java.util.Scanner;

public class UpdatePerformer {
    private final Scanner scanner = new Scanner(System.in);
    private final PerformerService performerService = new PerformerService();

    public void update() {
        Genre[] genres = Genre.values();
        System.out.println("Enter Performer Name: ");
        String performerName = scanner.nextLine();
        Performer performer = performerService
                .findByName(performerName);

        System.out.print("Enter Update Performer Name: ");
        String updatePerformerName = scanner.nextLine();
        Performer check = performerService
                .findByName(updatePerformerName);


        if (check == null) {
            performer.setName(updatePerformerName);
            System.out.print("Enter Update Genre: ");

            System.out.print("All genre: ");
            System.out.print(Arrays.toString(genres) + "\n");

            System.out.print("Enter performer genre: ");
            Genre genre = Genre.valueOf(scanner.nextLine());
            performer.setGenre(genre);
            performerService.save(performer);
        }
        else {
            throw new NameIsBusyException("Name = %s is already taken".formatted(updatePerformerName));
        }
    }
}
