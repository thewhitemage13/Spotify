package org.spotify.consolemenu;

import java.util.Scanner;

/**
 * The main menu of the Spotify console application.
 * <p>
 * The {@code MainMenu} class provides a user interface for navigating through
 * various submenus, such as the performer menu, song menu, music collection menu, radio menu, and player menu.
 * </p>
 *
 * <p>Each submenu is represented by a separate class, and interactions are handled
 * based on the user's selection.</p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class MainMenu {

    /**
     * Scanner for reading user input from the console.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Submenu for operations related to performers.
     * <p>Handles operations such as adding, updating, and searching for performers.</p>
     */
    private final PerformerMenu performerMenu = new PerformerMenu();

    /**
     * Submenu for operations related to songs.
     * <p>Handles operations such as adding, updating, and managing songs in the application.</p>
     */
    private final SongMenu songMenu = new SongMenu();

    /**
     * Submenu for operations related to the music player.
     * <p>Allows the user to control playback, manage playlists, and adjust player settings.</p>
     */
    private final PlayerMenu playerMenu = new PlayerMenu();

    /**
     * Submenu for operations related to radio.
     * <p>Handles radio functionalities such as tuning stations, saving presets, and playing radio streams.</p>
     */
    private final RadioMenu radioMenu = new RadioMenu();

    /**
     * Submenu for operations related to music collections.
     * <p>Enables the user to create, manage, and search through music collections.</p>
     */
    private final MusicCollectionMenu musicCollectionMenu = new MusicCollectionMenu();

    /**
     * Displays the main menu and processes the user's selection.
     *
     * <p>The main menu offers the following options:</p>
     * <ul>
     *     <li>Navigate to the performer menu</li>
     *     <li>Navigate to the song menu</li>
     *     <li>Navigate to the music collection menu</li>
     *     <li>Navigate to the radio menu</li>
     *     <li>Navigate to the player menu</li>
     *     <li>Exit the application</li>
     * </ul>
     *
     * <p>If an unknown option is selected, the menu is displayed again.</p>
     */
    public void menu() {
        System.out.println("Main menu:");
        System.out.println("1) -> Performer menu <- ");
        System.out.println("2) -> Song menu <- ");
        System.out.println("3) -> Music collection menu <- ");
        System.out.println("4) -> Radio menu <- ");
        System.out.println("5) -> Player menu <- ");
        System.out.println("6) -> Exit <- ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                performerMenu.menu();
                break;
            case 2:
                songMenu.menu();
                break;
            case 3:
                musicCollectionMenu.menu();
                break;
            case 4:
                radioMenu.menu();
                break;
            case 5:
                playerMenu.menu();
                break;
            case 6:
                break;
            default:
                System.out.println("Unknown choice " + choice);
                menu();
        }

    }
}
