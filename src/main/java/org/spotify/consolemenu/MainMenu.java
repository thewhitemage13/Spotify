package org.spotify.consolemenu;


import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final PerformerMenu performerMenu = new PerformerMenu();
    private final SongMenu songMenu = new SongMenu();
    private final PlayerMenu playerMenu = new PlayerMenu();
    private final RadioMenu radioMenu = new RadioMenu();
    private final MusicCollectionMenu musicCollectionMenu = new MusicCollectionMenu();

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
                performerMenu.manu();
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
                playerMenu.manu();
                break;
            case 6:
                break;
            default:
                System.out.println("Unknown choice " + choice);
                menu();
        }

    }
}
