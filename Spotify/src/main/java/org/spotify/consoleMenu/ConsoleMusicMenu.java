package org.spotify.consoleMenu;

import org.spotify.consolePlayer.ConsolePlayer;
import org.spotify.entity.MusicCollection;
import org.spotify.interfaces.MusicMenu;

import java.util.Scanner;
// Класс меню для музыки
public class ConsoleMusicMenu implements MusicMenu<MusicCollection> {
    @Override
    public void musicConsoleMenu(MusicCollection musicCollection){
        boolean menu = true;
        Scanner scanner = new Scanner(System.in);
        ConsoleMainMenu consoleMenu = new ConsoleMainMenu();
        ConsolePlayer consolePlayer = new ConsolePlayer();

        int choice;
        while (menu == true) {
            System.out.println("\nMusic Menu:");
            System.out.println(1 + ")" + " -> Play music from PC <-");
            System.out.println(2 + ")" + " -> Play the last added song <-");
            System.out.println(3 + ")" + " -> PLay music from Internet <-");
            System.out.println(4 + ")" + " -> Menu <-");
            System.out.println(5 + ")" + " -> Exit <-");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    consolePlayer.playFromPC();
                    break;
                    case 2:
                    consolePlayer.PlayTheLastAddedSong(musicCollection);
                    break;
                    case 3:
                        consolePlayer.playMusicFromInternet();
                        break;
                        case 4:
                            consoleMenu.menu();
                            break;
                            case 5:
                                menu = false;
                                break;
                                default:
                                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
