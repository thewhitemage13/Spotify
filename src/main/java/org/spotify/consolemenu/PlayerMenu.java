package org.spotify.consolemenu;

import org.spotify.managers.PlayerManager;

import java.util.Scanner;

public class PlayerMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final PlayerManager playerManager = new PlayerManager();

    public void manu() {
        System.out.println("Player Menu: ");

        System.out.println("1) -> Play Song <- ");
        System.out.println("2) -> Play Music Collection <- ");
        System.out.println("3) -> Play Radio <- ");
        System.out.println("4) -> Exit <- ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                playerManager.playMusic();
                break;
            case 2:
                playerManager.playMusicCollection();
                break;
            case 3:
                playerManager.playRadio();
                break;
            case 4:
                break;
            default:
                System.out.println("Unknown choice " + choice);
        }
    }
}
