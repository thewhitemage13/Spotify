package org.spotify.consolemenu;

import org.spotify.operations.PlayerOperations;

import java.util.Scanner;

/**
 * The menu for managing the player in the Spotify console application.
 *
 * <p>The {@code PlayerMenu} class provides a user interface to control playback operations,
 * such as playing a song, a music collection, or a radio station.</p>
 *
 * <p>This class integrates with the {@link PlayerOperations} class to execute the core playback functionalities.</p>
 *
 * <p>It allows users to:</p>
 * <ul>
 *     <li>Play an individual song</li>
 *     <li>Play a complete music collection</li>
 *     <li>Play a specific radio station</li>
 *     <li>Exit the menu</li>
 * </ul>
 *
 * <p>All user input is processed through the console using a {@link Scanner}.</p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class PlayerMenu {

    /**
     * Scanner for reading user input from the console.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Handles playback operations such as playing songs, music collections, or radio stations.
     * <p>This class provides methods to perform the actual playback actions.</p>
     */
    private final PlayerOperations playerOperations = new PlayerOperations();

    /**
     * Displays the player menu and processes the user's selection.
     * <p>
     * The menu offers the following options:
     * <ul>
     *     <li>Play a single song</li>
     *     <li>Play a music collection</li>
     *     <li>Play a radio station</li>
     *     <li>Exit the menu</li>
     * </ul>
     *
     * <p>If an unknown option is selected, the menu is displayed again.</p>
     */
    public void menu() {
        System.out.println("Player Menu: ");

        System.out.println("1) -> Play Song <- ");
        System.out.println("2) -> Play Music Collection <- ");
        System.out.println("3) -> Play Radio <- ");
        System.out.println("4) -> Exit <- ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                playerOperations.playSong();
                break;
            case 2:
                playerOperations.playMusicCollection();
                break;
            case 3:
                playerOperations.playRadio();
                break;
            case 4:
                break;
            default:
                System.out.println("Unknown choice " + choice);
                menu();
        }
    }
}
