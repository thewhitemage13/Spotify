package org.spotify.consolemenu;

import org.spotify.db.dao.PerformerDAO;
import org.spotify.db.dao.Repository;
import org.spotify.db.dao.SongDAO;
import org.spotify.entities.Performer;
import org.spotify.entities.Song;
import org.spotify.operations.Operation;
import org.spotify.operations.SongOperations;
import org.spotify.services.PerformerService;
import org.spotify.services.SongService;
import org.spotify.services.interfaces.Service;

import java.util.Scanner;

/**
 * The menu for managing songs in the Spotify console application.
 *
 * <p>The {@code SongMenu} class provides a user interface for performing CRUD operations
 * on songs, such as adding, deleting, updating, and searching for songs. It also supports
 * operations involving song-performer relationships.</p>
 *
 * <p>This class integrates with:</p>
 * <ul>
 *     <li>{@link SongService} for applying business logic to song-related data</li>
 *     <li>{@link PerformerService} for managing data related to song performers</li>
 *     <li>{@link SongOperations} for performing CRUD operations on songs</li>
 *     <li>{@link SongDAO} and {@link PerformerDAO} for database interaction</li>
 * </ul>
 *
 * <p>Key functionalities include:</p>
 * <ul>
 *     <li>Adding a new song</li>
 *     <li>Deleting an existing song</li>
 *     <li>Updating song details</li>
 *     <li>Searching for a song by its ID</li>
 *     <li>Listing all available songs</li>
 *     <li>Exiting the song menu</li>
 * </ul>
 *
 * <p>This menu interacts with the user via the console using a {@link Scanner}.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * SongMenu songMenu = new SongMenu();
 * songMenu.menu();
 * }</pre>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class SongMenu {

    /**
     * Scanner for reading user input from the console.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Repository for performing CRUD operations on {@link Song} entities.
     */
    private final Repository<Song> songRepository = new SongDAO();

    /**
     * Service layer for handling business logic related to {@link Song} entities.
     */
    private final Service<Song> songService = new SongService(songRepository);

    /**
     * Repository for performing CRUD operations on {@link Performer} entities.
     */
    private final Repository<Performer> performerRepository = new PerformerDAO();

    /**
     * Service layer for handling business logic related to {@link Performer} entities.
     */
    private final Service<Performer> performerService = new PerformerService(performerRepository);

    /**
     * Operations class for managing songs and their associations with performers.
     */
    private final Operation songOperations = new SongOperations(songService, performerService);

    /**
     * Displays the song menu and processes the user's selection.
     * <p>
     * The menu offers the following options:
     * <ul>
     *     <li>Add a new song</li>
     *     <li>Delete an existing song</li>
     *     <li>Update an existing song</li>
     *     <li>Find a song by its ID</li>
     *     <li>List all available songs</li>
     *     <li>Exit the menu</li>
     * </ul>
     *
     * <p>If an invalid option is selected, an error message is displayed, and the menu is shown again.</p>
     */
    public void menu() {
        System.out.println("Song Menu: ");

        System.out.println("1) -> Add Song <- ");
        System.out.println("2) -> Delete Song <- ");
        System.out.println("3) -> Update Song <- ");
        System.out.println("4) -> Find Song By Id <- ");
        System.out.println("5) -> Find All Songs <- ");
        System.out.println("6) -> Exit <- ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                songOperations.addOperation();
                break;
            case 2:
                songOperations.deleteOperation();
                break;
            case 3:
                songOperations.updateOperation();
                break;
            case 4:
                songOperations.findByIdOperation();
                break;
            case 5:
                songOperations.findAllOperations();
                break;
            case 6:
                break;
            default:
                System.out.println("Unknown choice " + choice);
                menu();
        }
    }
}
