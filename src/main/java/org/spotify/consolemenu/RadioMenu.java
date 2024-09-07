package org.spotify.consolemenu;

import org.spotify.managers.RadioManager;

import java.util.Scanner;

public class RadioMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final RadioManager radioManager = new RadioManager();

    public void menu() {
        System.out.println("Radio Menu: ");

        System.out.println("1) -> Add Radio <- ");
        System.out.println("2) -> Delete Radio <- ");
        System.out.println("3) -> Update Radio <- ");
        System.out.println("4) -> Print Radio <- ");
        System.out.println("5) -> Exit <- ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                radioManager.add();
                break;
            case 2:
                radioManager.delete();
                break;
            case 3:
                radioManager.update();
                break;
            case 4:
                radioManager.print();
                break;
            case 5:
                break;
            default:
                System.out.println("Unknown choice " + choice);
        }
    }
}
