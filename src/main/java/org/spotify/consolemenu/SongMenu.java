package org.spotify.consolemenu;

import org.spotify.managers.SongManager;

import java.util.Scanner;

public class SongMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final SongManager songManager = new SongManager();

    public void menu() {
        System.out.println("Song Menu: ");

        System.out.println("1) -> Add Song <- ");
        System.out.println("2) -> Delete Song <- ");
        System.out.println("3) -> Update Song <- ");
        System.out.println("4) -> Print Song <- ");
        System.out.println("5) -> Exit <- ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                songManager.add();
                break;
            case 2:
                songManager.delete();
                break;
            case 3:
                songManager.update();
                break;
            case 4:
                songManager.print();
                break;
            case 5:
                break;
            default:
                System.out.println("Unknown choice " + choice);
        }
    }
}
