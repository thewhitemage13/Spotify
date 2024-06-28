package org.spotify.consoleMenu;

import org.spotify.consoleRadio.ConsoleRadio;
import org.spotify.interfaces.Menu;

import java.util.Scanner;
// Класс радио меню
// Реализует interface Menu
public class ConsoleRadioMenu implements Menu {
    public void menu() {
        boolean menu = true;
        Scanner scanner = new Scanner(System.in);
        ConsoleMainMenu consoleMenu = new ConsoleMainMenu();
        ConsoleRadio consoleRadio = new ConsoleRadio();

        int choice;
        while(menu == true){
            System.out.println("\nRadio Menu:");
            System.out.println(1 + ")" + " -> 1+1 <-");
            System.out.println(2 + ")" + " -> 106.1 FM <-");
            System.out.println(3 + ")" + " -> Channel 5 <-");
            System.out.println(4 + ")" + " -> Best FM <-");
            System.out.println(5 + ")" + " -> DJFM <-");
            System.out.println(6 + ")" + " -> Hit FM <-");
            System.out.println(7 + ")" + " -> Kiss FM Ukraine <-");
            System.out.println(8 + ")" + " -> Radio Bayraktar <-");
            System.out.println(9 + ")" + " -> Specify your radio station <-");
            System.out.println(10 + ")" + " -> Menu <-");
            System.out.println(11 + ")" + " -> Exit <-");

            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    consoleRadio.playRadio("https://1plus1.video/tvguide/1plus1/online");
                    break;
                    case 2:
                        consoleRadio.playRadio("http://109.251.190.11:8888/live");
                        break;
                        case 3:
                            consoleRadio.playRadio("https://www.5.ua/live/#");
                            break;
                            case 4:
                                consoleRadio.playRadio("https://radio.perec.fm/bestfm");
                                break;
                                case 5:
                                    consoleRadio.playRadio("https://cast.fex.net/djfm_x");
                                    break;
                                    case 6:
                                        consoleRadio.playRadio("https://online.hitfm.ua/HitFM");
                                        break;
                                        case 7:
                                            consoleRadio.playRadio("http://www.kissfm.ua/KissFM.m3u");
                                            break;
                                            case 8:
                                                consoleRadio.playRadio("https://online.radiobayraktar.ua/RadioBayraktar");
                                                break;
                                                case 9:
                                                    consoleRadio.playRadio();
                                                    break;
                                                    case 10:
                                                        consoleMenu.menu();
                                                        break;
                case 11:
                    menu = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
