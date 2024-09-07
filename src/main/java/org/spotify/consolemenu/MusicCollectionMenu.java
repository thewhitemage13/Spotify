package org.spotify.consolemenu;

import org.spotify.managers.MusicCollectionManager;

import java.util.Scanner;

public class MusicCollectionMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final MusicCollectionManager musicCollectionManager = new MusicCollectionManager();

    public void menu() {
        System.out.println("Music Collection menu:");

        System.out.println("1) -> Add Music Collection <- ");
        System.out.println("2) -> Delete Music Collection <- ");
        System.out.println("3) -> Update Music Collection <- ");
        System.out.println("4) -> Print Music Collection <- ");
        System.out.println("5) -> Exit <- ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                musicCollectionManager.add();
                break;
            case 2:
                musicCollectionManager.delete();
                break;
            case 3:
                musicCollectionManager.update();
                break;
            case 4:
                musicCollectionManager.print();
                break;
            case 5:
                break;
            default:
                System.out.println("Unknown choice " + choice);
        }
    }
}
