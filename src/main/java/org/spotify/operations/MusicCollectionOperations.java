package org.spotify.operations;

import org.spotify.entities.MusicCollection;
import org.spotify.entities.Performer;
import org.spotify.entities.Song;
import org.spotify.enums.TypeOfMusicCollection;
import org.spotify.services.interfaces.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Provides operations for managing {@link MusicCollection} entities, such as adding, updating,
 * deleting, and retrieving music collections.
 * <p>
 * This class handles user input and orchestrates interactions between {@link MusicCollection},
 * {@link Song}, and {@link Performer} entities. It communicates with the corresponding service
 * layers to persist and manipulate data.
 * </p>
 * <p>
 * The operations include adding a new music collection, updating an existing one, deleting a
 * music collection, retrieving all music collections, and finding a music collection by its ID.
 * The class also includes functionality to associate performers and songs with music collections.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class MusicCollectionOperations implements Operation {

    /**
     * The service used to perform operations on music collections.
     */
    private final Service<MusicCollection> musicCollectionService;

    /**
     * The service used to perform operations on performers.
     */
    private final Service<Performer> performerService;

    /**
     * A scanner used to read user input from the console.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * An instance of {@link SongOperations} for managing songs associated with music collections.
     */
    private final SongOperations songOperations;

    /**
     * Constructs a new {@code MusicCollectionOperations} instance.
     *
     * @param musicCollectionService the service for handling music collection operations
     * @param performerService the service for handling performer operations
     * @param songOperations the operations for managing songs
     */
    public MusicCollectionOperations(Service<MusicCollection> musicCollectionService,
                                     Service<Performer> performerService,
                                     SongOperations songOperations) {
        this.musicCollectionService = musicCollectionService;
        this.performerService = performerService;
        this.songOperations = songOperations;
    }

    /**
     * Adds a new {@link MusicCollection} by prompting the user for input.
     * The music collection is saved to the database.
     */
    @Override
    public void addOperation() {
        MusicCollection musicCollection = new MusicCollection();
        createProcessor(musicCollection);
        musicCollectionService.save(musicCollection);
    }

    /**
     * Updates an existing {@link MusicCollection}. The user is prompted for the music collection ID
     * and then for the new details of the music collection.
     */
    @Override
    public void updateOperation() {
        System.out.print("Enter Music Collection ID: ");
        Long id = scanner.nextLong();
        MusicCollection musicCollection = musicCollectionService.findById(id);
        createProcessor(musicCollection);
        musicCollectionService.update(musicCollection);
    }

    /**
     * Deletes a {@link MusicCollection} by ID.
     */
    @Override
    public void deleteOperation() {
        System.out.print("Enter Music Collection ID: ");
        Long id = scanner.nextLong();
        musicCollectionService.delete(id);
    }

    /**
     * Retrieves and displays all {@link MusicCollection} entities.
     */
    @Override
    public void findAllOperations() {
        List<MusicCollection> musicCollections = musicCollectionService.findAll();
        for (MusicCollection musicCollection : musicCollections) {
            System.out.println(musicCollection);
        }
    }

    /**
     * Retrieves and displays a {@link MusicCollection} by its ID.
     */
    @Override
    public void findByIdOperation() {
        System.out.println("Enter Music Collection ID: ");
        Long id = scanner.nextLong();
        MusicCollection musicCollection = musicCollectionService.findById(id);
        System.out.println(musicCollection);
    }

    /**
     * Prompts the user for details to create or update a {@link MusicCollection}.
     *
     * @param musicCollection the music collection to be created or updated
     */
    private void createProcessor(MusicCollection musicCollection) {
        TypeOfMusicCollection[] types = TypeOfMusicCollection.values();
        Scanner scanner = new Scanner(System.in);

        // Select performer
        System.out.print("Enter Performer Id: ");
        Long id = scanner.nextLong();

        Performer performer = performerService
                .findById(id);

        musicCollection.setPerformer(performer);

        // Set music collection name
        System.out.print("Please enter the name of the album: ");
        String name = scanner.nextLine();
        musicCollection.setName(name);

        // Select type of music collection
        System.out.print("All type of Music Collection: ");
        System.out.print(Arrays.toString(types) + "\n");

        System.out.print("Enter the type of the music collection: ");
        TypeOfMusicCollection typeOfCollection = TypeOfMusicCollection.valueOf(scanner.nextLine());
        musicCollection.setTypeOfCollection(typeOfCollection);

        // Set release date
        LocalDate releaseDate = null;
        while (releaseDate == null) {
            System.out.print("Please enter the release date (yyyy-MM-dd): ");
            String dateInput = scanner.nextLine();
            try {
                releaseDate = LocalDate.parse(dateInput);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            }
        }

        musicCollection.setReleaseDate(releaseDate);

        musicCollection.setPerformer(performer);

        // Add songs to music collection
        addSongsToAlbum(musicCollection);
        musicCollectionService.save(musicCollection);

    }

    /**
     * Prompts the user to add songs to a {@link MusicCollection}.
     *
     * @param musicCollection the music collection to which songs are added
     */
    private void addSongsToAlbum(MusicCollection musicCollection) {
        Scanner scanner = new Scanner(System.in);
        String addMore;
        do {
            System.out.println("Add a new song to the album:");
            Song song = new Song();

            songOperations.addOperation(song);

            musicCollection.add(song);

            System.out.print("Do you want to add another song? (yes/no): ");
            addMore = scanner.nextLine().trim().toLowerCase();
        } while (addMore.equals("yes"));
    }
}
