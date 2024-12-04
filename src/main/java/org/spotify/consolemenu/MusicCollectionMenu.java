package org.spotify.consolemenu;

import org.spotify.db.dao.MusicCollectionDAO;
import org.spotify.db.dao.PerformerDAO;
import org.spotify.db.dao.Repository;
import org.spotify.db.dao.SongDAO;
import org.spotify.entities.MusicCollection;
import org.spotify.entities.Performer;
import org.spotify.entities.Song;
import org.spotify.operations.MusicCollectionOperations;
import org.spotify.operations.SongOperations;
import org.spotify.services.MusicCollectionService;
import org.spotify.services.PerformerService;
import org.spotify.services.SongService;
import org.spotify.services.interfaces.Service;

import java.util.Scanner;

/**
 * The menu for managing music collections in the Spotify console application.
 * <p>
 * The {@code MusicCollectionMenu} class provides a user interface to interact with music collections,
 * allowing the user to perform CRUD operations such as adding, deleting, updating, and searching for music collections.
 * </p>
 *
 * <p>This class integrates with various services, DAOs, and operations classes to provide functionality.</p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class MusicCollectionMenu {

    /**
     * Scanner for reading user input from the console.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Repository implementation for managing {@link Song} entities.
     * <p>Uses {@link SongDAO} to provide database access for song-related operations.</p>
     */
    private final Repository<Song> songRepository = new SongDAO();

    /**
     * Service implementation for handling business logic related to songs.
     * <p>Built on top of {@link SongDAO} to facilitate operations like adding or searching songs.</p>
     */
    private final Service<Song> songService = new SongService(songRepository);

    /**
     * Repository implementation for managing {@link MusicCollection} entities.
     * <p>Uses {@link MusicCollectionDAO} to provide database access for music collection-related operations.</p>
     */
    private final Repository<MusicCollection> musicCollectionRepository = new MusicCollectionDAO();

    /**
     * Service implementation for handling business logic related to music collections.
     * <p>Built on top of {@link MusicCollectionDAO} to facilitate CRUD operations for music collections.</p>
     */
    private final Service<MusicCollection> musicCollectionService = new MusicCollectionService(musicCollectionRepository);

    /**
     * Repository implementation for managing {@link Performer} entities.
     * <p>Uses {@link PerformerDAO} to provide database access for performer-related operations.</p>
     */
    private final Repository<Performer> performerRepository = new PerformerDAO();

    /**
     * Service implementation for handling business logic related to performers.
     * <p>Built on top of {@link PerformerDAO} to manage operations like adding or searching performers.</p>
     */
    private final Service<Performer> performerService = new PerformerService(performerRepository);

    /**
     * Helper class for managing operations related to songs.
     * <p>Integrates {@link SongService} and {@link PerformerService} to handle complex operations
     * like associating songs with performers.</p>
     */
    private final SongOperations songOperations = new SongOperations(songService, performerService);

    /**
     * Helper class for managing operations related to music collections.
     * <p>Integrates {@link MusicCollectionService}, {@link PerformerService}, and {@link SongOperations}
     * to perform advanced operations such as linking collections with songs and performers.</p>
     */
    private final MusicCollectionOperations musicCollectionOperations =
            new MusicCollectionOperations
                    (
                            musicCollectionService, performerService, songOperations
                    );

    /**
     * Displays the music collection menu and processes the user's selection.
     *
     * <p>The menu offers the following options:</p>
     * <ul>
     *     <li>Add a new music collection</li>
     *     <li>Delete an existing music collection</li>
     *     <li>Update an existing music collection</li>
     *     <li>Find a music collection by its ID</li>
     *     <li>List all available music collections</li>
     *     <li>Exit the menu</li>
     * </ul>
     *
     * <p>If an unknown option is selected, the menu is displayed again.</p>
     */
    public void menu() {
        System.out.println("Music Collection menu:");

        System.out.println("1) -> Add Music Collection <- ");
        System.out.println("2) -> Delete Music Collection <- ");
        System.out.println("3) -> Update Music Collection <- ");
        System.out.println("4) -> Find Music Collection By Id <- ");
        System.out.println("5) -> Find All Music Collections <- ");
        System.out.println("6) -> Exit <- ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                musicCollectionOperations.addOperation();
                break;
            case 2:
                musicCollectionOperations.deleteOperation();
                break;
            case 3:
                musicCollectionOperations.updateOperation();
                break;
            case 4:
                musicCollectionOperations.findByIdOperation();
                break;
            case 5:
                musicCollectionOperations.findAllOperations();
                break;
            case 6:
                break;
            default:
                System.out.println("Unknown choice " + choice);
                menu();
        }
    }
}
