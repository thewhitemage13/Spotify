package org.spotify.operations;

import org.spotify.entities.Performer;
import org.spotify.entities.Song;
import org.spotify.enums.Genre;
import org.spotify.enums.TypeOfSong;
import org.spotify.services.interfaces.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Provides operations for managing songs in the system.
 * <p>
 * This class allows for adding, updating, deleting, and retrieving song entities through
 * interactions with the {@link Service} interface. Each song includes information such as
 * performer, name, type, duration, file path, and genre.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class SongOperations implements Operation {

    /**
     * The service used for performing operations on {@link Song} entities.
     * This service interacts with the data layer to save, update, retrieve, and delete songs.
     */
    private final Service<Song> songService;

    /**
     * The service used for retrieving {@link Performer} entities.
     * This service allows for fetching the performers associated with songs.
     */
    private final Service<Performer> performerService;

    /**
     * A {@link Scanner} object used for gathering user input through the console.
     * This is used in the methods to prompt the user for details about songs and performers.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a {@link SongOperations} instance with the specified services for managing songs
     * and performers.
     *
     * @param songService the service used for performing operations on {@link Song} entities.
     * @param performerService the service used for retrieving {@link Performer} entities.
     */
    public SongOperations(Service<Song> songService, Service<Performer> performerService) {
        this.songService = songService;
        this.performerService = performerService;
    }

    /**
     * Adds a new song to the system.
     * <p>
     * This method collects the necessary details from the user, creates a new {@link Song} object,
     * and saves it using the {@link Service#save(Object)} method.
     * </p>
     */
    public void addOperation() {
        Song song = new Song();
        createProcessor(song);
        songService.save(song);
    }

    /**
     * Adds an existing song to the system.
     * <p>
     * This method collects the necessary details for an already provided {@link Song} object and saves it.
     * </p>
     *
     * @param song the {@link Song} object to be added to the system.
     */
    public void addOperation(Song song) {
        createProcessor(song);
        songService.save(song);
    }

    /**
     * Updates an existing song in the system.
     * <p>
     * This method prompts the user to enter the song's ID, retrieves the existing song from the system,
     * allows the user to modify its details, and then updates it using the {@link Service#update(Object)} method.
     * </p>
     */
    public void updateOperation() {
        System.out.println("Enter Song Id: ");
        Long id = scanner.nextLong();
        Song song = songService.findById(id);
        createProcessor(song);
        songService.update(song);
    }

    /**
     * Deletes a song from the system.
     * <p>
     * This method prompts the user to enter the song's ID and deletes the corresponding song
     * from the system using the {@link Service#delete(Long)} method.
     * </p>
     */
    public void deleteOperation() {
        System.out.println("Enter Song Id: ");
        Long id = scanner.nextLong();
        songService.delete(id);
    }

    /**
     * Retrieves and displays all songs in the system.
     * <p>
     * This method fetches all songs using the {@link Service#findAll()} method and prints their details.
     * </p>
     */
    public void findAllOperations() {
        List<Song> songs = songService.findAll();
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    /**
     * Retrieves and displays a song by its ID.
     * <p>
     * This method prompts the user for the song's ID, fetches the song using the
     * {@link Service#findById(Long)} method, and prints its details.
     * </p>
     */
    public void findByIdOperation() {
        Long id = scanner.nextLong();
        Song song = songService.findById(id);
        System.out.println(song);
    }

    /**
     * Collects the necessary details to create or update a {@link Song} object.
     * <p>
     * This method prompts the user for details such as performer ID, song name, type, duration, file path,
     * and genre, and sets these values on the provided {@link Song} object.
     * </p>
     *
     * @param song the {@link Song} object to be created or updated.
     */
    private void createProcessor(Song song) {
        Scanner scanner = new Scanner(System.in);
        TypeOfSong[] typeOfSongs = TypeOfSong.values();
        Genre[] genres = Genre.values();

        System.out.print("Enter Performer Id: ");
        Long id = scanner.nextLong();
        Performer performer = performerService
                .findById(id);

        song.setPerformer(performer);

        System.out.print("Enter Song Name: ");
        String name = scanner.nextLine();
        song.setName(name);
        System.out.print("All type of song:");
        System.out.println(Arrays.toString(typeOfSongs));

        System.out.print("Enter the type of song: ");
        TypeOfSong typeOfSong = TypeOfSong.valueOf(scanner.nextLine());
        song.setTypeOfSong(typeOfSong);

        System.out.print("Duration: ");
        int duration = scanner.nextInt();
        song.setDuration(duration);

        scanner.nextLine();

        System.out.print("Enter path: ");
        String path = scanner.nextLine();
        song.setFilePath(path);

        System.out.print("All Genre: ");
        System.out.print(Arrays.toString(genres) + "\n");

        System.out.print("Enter song genre: ");
        Genre genre = Genre.valueOf(scanner.nextLine());
        song.setGenre(genre);
    }
}
