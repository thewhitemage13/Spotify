package org.spotify.consolemenu;

import org.spotify.managers.PerformerManager;

import java.util.Scanner;

public class PerformerMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final PerformerManager performerManager = new PerformerManager();

    public void manu() {
        System.out.println("Performer Menu: ");

        System.out.println("1) -> Add Performer <- ");
        System.out.println("2) -> Delete Performer <- ");
        System.out.println("3) -> Update Performer <- ");
        System.out.println("4) -> Print Performer <- ");
        System.out.println("5) -> Exit <- ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                performerManager.add();
                break;
            case 2:
                performerManager.delete();
                break;
            case 3:
                performerManager.update();
                break;
            case 4:
                performerManager.print();
                break;
            case 5:
                break;
            default:
                System.out.println("Unknown choice " + choice);
        }
    }
}
