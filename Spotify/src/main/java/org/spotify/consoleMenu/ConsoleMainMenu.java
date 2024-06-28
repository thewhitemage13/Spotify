package org.spotify.consoleMenu;

import org.spotify.consoleInput.ConsoleInputMusicCollection;
import org.spotify.consoleInput.ConsoleInputPerformer;
import org.spotify.consoleInput.ConsoleInputSong;
import org.spotify.consolePrinter.ConsoleMusicCollectionPrinter;
import org.spotify.consolePrinter.ConsolePerformerPrinter;
import org.spotify.consolePrinter.ConsoleSongPrinter;
import org.spotify.entity.MusicCollection;
import org.spotify.entity.Performer;
import org.spotify.entity.Song;
import org.spotify.interfaces.Menu;

import java.util.Scanner;
// Класс основного меню
// Реализует interface Menu
public class ConsoleMainMenu implements Menu {
    @Override
    public void menu(){
        boolean menu = true;
        Scanner scanner = new Scanner(System.in);
        Song song = new Song();
        MusicCollection musicCollection = new MusicCollection();
        Performer performer = new Performer();
        ConsoleMusicMenu consoleMusicMenu = new ConsoleMusicMenu();
        ConsoleRadioMenu consoleRadioMenu = new ConsoleRadioMenu();

        ConsoleInputPerformer consoleInputPerformer = new ConsoleInputPerformer();
        ConsoleInputMusicCollection consoleInputAlbum = new ConsoleInputMusicCollection();
        ConsoleInputSong consoleInputSong = new ConsoleInputSong();

        ConsoleMusicCollectionPrinter consoleAlbumPrinter = new ConsoleMusicCollectionPrinter();
        ConsoleSongPrinter consoleSongPrinter = new ConsoleSongPrinter();
        ConsolePerformerPrinter consolePerformerPrinter = new ConsolePerformerPrinter();

        int choice;
        while(menu == true){
            System.out.println("\nMenu: ");
            System.out.println(1 + ")" + " -> Add performer <-");
            System.out.println(2 + ")" + " -> Add album <-");
            System.out.println(3 + ")" + " -> Add song <-");
            System.out.println(4 + ")" + " -> Player menu <-");
            System.out.println(5 + ")" + " -> Show information about performer <-");
            System.out.println(6 + ")" + " -> Show information about album <-");
            System.out.println(7 + ")" + " -> Show information about song <-");
            System.out.println(8 + ")" + " -> Radio menu <-");
            System.out.println(9 + ")" + " -> Exit <-");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    consoleInputPerformer.input(performer);
                    break;
                case 2:
                    consoleInputAlbum.input(musicCollection, performer);
                    performer.add(musicCollection);
                    break;
                case 3:
                    consoleInputSong.input(song);
                    musicCollection.add(song);
                    break;
                    case 4:
                        consoleMusicMenu.musicConsoleMenu(musicCollection);
                        break;
                        case 5:
                            consolePerformerPrinter.print(performer);
                            break;
                            case 6:
                                consoleAlbumPrinter.print(musicCollection);
                                break;
                                case 7:
                                    consoleSongPrinter.print(song);
                                    break;
                                        case 8:
                                            consoleRadioMenu.menu();
                                            case 9:
                                                menu = false;
                                                break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
