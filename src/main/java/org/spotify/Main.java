package org.spotify;


import org.spotify.consolemenu.MainMenu;

/**
 * Entry point for the Spotify application.
 * <p>
 * This class initializes and starts the main menu of the application.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class Main {

    /**
     * The main method, serving as the entry point of the application.
     * <p>
     * This method creates an instance of {@link MainMenu} and invokes its
     * {@code menu()} method to start the user interface.
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.menu();
    }
}
