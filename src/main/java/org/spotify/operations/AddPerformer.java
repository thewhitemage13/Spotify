package org.spotify.operations;

import org.spotify.enums.Genre;
import org.spotify.entities.Performer;
import org.spotify.exceptions.NameIsBusyException;
import org.spotify.services.PerformerService;

import java.util.Arrays;
import java.util.Scanner;

public class AddPerformer {
    private final PerformerService performerService = new PerformerService();

    public void add() {
        Scanner scanner = new Scanner(System.in);

        Genre[] genres = Genre.values();

        System.out.print("Enter performer name: ");
        String name = scanner.nextLine();
        Performer performer = performerService
                .findByName(name);

        if (performer != null) {
            throw new NameIsBusyException("Name = %s is busy: ".formatted(name));
        }
        else {
            performer = new Performer();
            performer.setName(name);

            System.out.print("All genre: ");
            System.out.print(Arrays.toString(genres) + "\n");

            System.out.print("Enter performer genre: ");
            Genre genre = Genre.valueOf(scanner.nextLine());
            performer.setGenre(genre);

            performerService.save(performer);
        }
    }
}