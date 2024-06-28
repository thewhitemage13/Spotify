package org.spotify.consolePrinter;

import org.spotify.entity.Performer;
import org.spotify.interfaces.Printer;
// Класс для вывода на консоль информации о нашем исполнителе
// Релизует interface Printer
public class ConsolePerformerPrinter implements Printer<Performer> {
    @Override
    public void print(Performer performer) {
        ConsoleMusicCollectionPrinter printer = new ConsoleMusicCollectionPrinter();
        System.out.println("Name: " + performer.getName());
        System.out.println("Genre: " + performer.getGenre());
        System.out.print("Albums: " + performer.getMusicCollection());
    }
}
