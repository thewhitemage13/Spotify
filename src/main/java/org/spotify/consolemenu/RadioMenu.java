package org.spotify.consolemenu;

import org.spotify.db.dao.RadioDAO;
import org.spotify.db.dao.Repository;
import org.spotify.entities.Radio;
import org.spotify.operations.Operation;
import org.spotify.operations.RadioOperations;
import org.spotify.services.RadioService;
import org.spotify.services.interfaces.Service;

import java.util.Scanner;

/**
 * The menu for managing radio stations in the Spotify console application.
 *
 * <p>The {@code RadioMenu} class provides a user interface for performing CRUD operations
 * on radio stations, such as adding, deleting, updating, and searching for radios.</p>
 *
 * <p>This class integrates with:</p>
 * <ul>
 *     <li>{@link RadioService} for applying business logic to radio data</li>
 *     <li>{@link RadioOperations} for executing CRUD operations</li>
 *     <li>{@link RadioDAO} for database interaction</li>
 * </ul>
 *
 * <p>The class enables the user to:</p>
 * <ul>
 *     <li>Add a new radio station</li>
 *     <li>Delete an existing radio station</li>
 *     <li>Update details of an existing radio station</li>
 *     <li>Find a radio station by its unique identifier</li>
 *     <li>View a list of all available radio stations</li>
 *     <li>Exit the radio menu</li>
 * </ul>
 *
 * <p>All user input is processed via the console using a {@link Scanner}.</p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class RadioMenu {

    /**
     * Scanner used for reading user input from the console.
     * <p>
     * It captures user commands to navigate the menu and interact with radio-related operations.
     * </p>
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Repository for performing database operations on {@link Radio} entities.
     * <p>
     * This repository handles direct interactions with the database for CRUD operations.
     * </p>
     */
    private final Repository<Radio> radioRepository = new RadioDAO();

    /**
     * Service class for implementing business logic related to radio stations.
     * <p>
     * The {@code RadioService} acts as an intermediary between the repository and operations
     * to provide validation and ensure data integrity.
     * </p>
     */
    private final Service<Radio> radioService = new RadioService(radioRepository);

    /**
     * Operations class providing specific methods for managing radio CRUD actions.
     * <p>
     * These operations allow adding, deleting, updating, finding, and listing radio stations
     * via the {@link RadioService}.
     * </p>
     */
    private final Operation radioOperations = new RadioOperations(radioService);

    /**
     * Displays the radio menu and processes the user's selection.
     * <p>
     * The menu offers the following options:
     * <ul>
     *     <li>Add a new radio station</li>
     *     <li>Delete an existing radio station</li>
     *     <li>Update details of an existing radio station</li>
     *     <li>Find a radio station by its unique ID</li>
     *     <li>View a list of all radio stations</li>
     *     <li>Exit the menu</li>
     * </ul>
     *
     *
     * <p>If an invalid option is selected, an error message is displayed, and the menu is shown again.</p>
     */
    public void menu() {
        System.out.println("Radio Menu: ");

        System.out.println("1) -> Add Radio <- ");
        System.out.println("2) -> Delete Radio <- ");
        System.out.println("3) -> Update Radio <- ");
        System.out.println("4) -> Find Radio By Id <- ");
        System.out.println("5) -> Find All Radios <- ");
        System.out.println("6) -> Exit <- ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                radioOperations.addOperation();
                break;
            case 2:
                radioOperations.deleteOperation();
                break;
            case 3:
                radioOperations.updateOperation();
                break;
            case 4:
                radioOperations.findByIdOperation();
                break;
            case 5:
                radioOperations.findAllOperations();
                break;
            case 6:
                break;
            default:
                System.out.println("Unknown choice " + choice);
                menu();
        }
    }
}
