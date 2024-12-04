package org.spotify.consolemenu;

import org.spotify.db.dao.PerformerDAO;
import org.spotify.db.dao.Repository;
import org.spotify.entities.Performer;
import org.spotify.operations.Operation;
import org.spotify.operations.PerformerOperations;
import org.spotify.services.PerformerService;
import org.spotify.services.interfaces.Service;

import java.util.Scanner;

/**
 * The menu for managing performers in the Spotify console application.
 *
 * <p>The {@code PerformerMenu} class provides a user interface for interacting with performer-related operations,
 * such as adding, deleting, updating, and searching for performers.</p>
 *
 * <p>This class integrates with the {@link PerformerService}, {@link PerformerOperations}, and
 * {@link PerformerDAO} to execute operations on the performer data.</p>
 *
 * <p>The menu allows users to perform the following actions:</p>
 * <ul>
 *     <li>Add a new performer</li>
 *     <li>Delete an existing performer</li>
 *     <li>Update details of an existing performer</li>
 *     <li>Search for a performer by their ID</li>
 *     <li>List all performers in the database</li>
 *     <li>Exit the menu</li>
 * </ul>
 *
 * <p>All input is taken from the console using a {@link Scanner}, and each action is executed
 * using the relevant methods in the {@link PerformerOperations} class.</p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class PerformerMenu {

    /**
     * Scanner for reading user input from the console.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Repository for managing {@link Performer} entities.
     * <p>This repository provides low-level access to the database for CRUD operations
     * on {@link Performer} objects.</p>
     */
    private final Repository<Performer> performerRepository = new PerformerDAO();

    /**
     * Service for managing business logic related to performers.
     * <p>This service is built on top of {@link PerformerDAO} and contains methods for
     * interacting with the repository while implementing business rules.</p>
     */
    private final Service<Performer> performerService = new PerformerService(performerRepository);

    /**
     * Operations class for handling CRUD operations on performers.
     * <p>Uses {@link PerformerService} to execute high-level operations such as adding,
     * deleting, updating, and searching for performers.</p>
     */
    private final Operation performerOperations = new PerformerOperations(performerService);

    /**
     * Displays the performer menu and processes the user's selection.
     *
     * <p>The menu offers the following options:</p>
     * <ul>
     *     <li>Add a new performer</li>
     *     <li>Delete an existing performer</li>
     *     <li>Update details of an existing performer</li>
     *     <li>Search for a performer by their ID</li>
     *     <li>List all performers in the database</li>
     *     <li>Exit the menu</li>
     * </ul>
     *
     * <p>If an unknown option is selected, the menu is displayed again.</p>
     */
    public void menu() {
        System.out.println("Performer Menu: ");

        System.out.println("1) -> Add Performer <- ");
        System.out.println("2) -> Delete Performer <- ");
        System.out.println("3) -> Update Performer <- ");
        System.out.println("4) -> Find Performer By Id <- ");
        System.out.println("5) -> Find All Performers <- ");
        System.out.println("6) -> Exit <- ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                performerOperations.addOperation();
                break;
            case 2:
                performerOperations.deleteOperation();
                break;
            case 3:
                performerOperations.updateOperation();
                break;
            case 4:
                performerOperations.findByIdOperation();
                break;
            case 5:
                performerOperations.findAllOperations();
                break;
            case 6:
                break;
            default:
                System.out.println("Unknown choice " + choice);
                menu();
        }
    }
}
