package org.spotify.operations;

import org.spotify.entities.Performer;
import org.spotify.enums.Genre;
import org.spotify.services.interfaces.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Provides operations for managing {@link Performer} entities, such as adding, updating,
 * deleting, and retrieving performers.
 * <p>
 * This class handles user input and interacts with the performer service to persist and manipulate data.
 * It allows users to perform CRUD operations on performer entities.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class PerformerOperations implements Operation {

    /**
     * The service used to perform operations on performer entities.
     * This field interacts with the database to save, update, delete, and retrieve performers.
     */
    private final Service<Performer> performerService;

    /**
     * A scanner used to read user input from the console.
     * This field is used to gather input from the user during various operations, such as adding or updating performers.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a new {@code PerformerOperations} instance.
     *
     * @param performerService the service for handling performer operations
     */
    public PerformerOperations(Service<Performer> performerService) {
        this.performerService = performerService;
    }

    /**
     * Adds a new {@link Performer} by prompting the user for input.
     * The performer is saved to the database.
     */
    @Override
    public void addOperation() {
        Performer performer = new Performer();
        createProcessor(performer);
        performerService.save(performer);
    }

    /**
     * Updates an existing {@link Performer}. The user is prompted for the performer ID
     * and then for the new details of the performer.
     */
    @Override
    public void updateOperation() {
        System.out.print("Enter performer Id: ");
        Long id = scanner.nextLong();
        Performer performer = performerService.findById(id);
        createProcessor(performer);
        performerService.update(performer);
    }

    /**
     * Deletes a {@link Performer} by ID.
     */
    @Override
    public void deleteOperation() {
        System.out.print("Enter performer Id: ");
        Long id = scanner.nextLong();
        performerService.delete(id);
    }

    /**
     * Retrieves and displays all {@link Performer} entities.
     */
    @Override
    public void findAllOperations() {
        List<Performer> performers = performerService.findAll();
        System.out.println("Performers found:");
        for (Performer performer : performers) {
            System.out.println(performer);
        }
    }

    /**
     * Retrieves and displays a {@link Performer} by its ID.
     */
    @Override
    public void findByIdOperation() {
        System.out.print("Enter performer Id: ");
        Long id = scanner.nextLong();
        Performer performer = performerService.findById(id);
        System.out.println(performer);
    }

    /**
     * Prompts the user for details to create or update a {@link Performer}.
     *
     * @param performer the performer to be created or updated
     */
    private void createProcessor(Performer performer) {
        Genre[] genres = Genre.values();

        System.out.print("Enter performer name: ");
        String name = scanner.nextLine();
        performer.setName(name);

        System.out.print("All genre: ");
        System.out.print(Arrays.toString(genres) + "\n");

        System.out.print("Enter performer genre: ");
        Genre genre = Genre.valueOf(scanner.nextLine());
        performer.setGenre(genre);
    }
}
