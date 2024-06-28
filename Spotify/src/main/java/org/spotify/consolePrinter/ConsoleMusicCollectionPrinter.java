package org.spotify.consolePrinter;


import org.spotify.entity.MusicCollection;
import org.spotify.interfaces.Printer;
// Класс для вывода информации о нашей музыкальной коллеции
// Реализует interface Printer
public class ConsoleMusicCollectionPrinter implements Printer<MusicCollection> {
    @Override
    public void print(MusicCollection musicCollection) {
        System.out.println("Name: " + musicCollection.getName());
        System.out.println("Type of collection: " + musicCollection.getTypeOfCollection());
        System.out.println("Performer: " + musicCollection.getPerformer());
        System.out.println("Date: " + musicCollection.getReleaseDate());
        for (int i = 0; i < musicCollection.getSong().size(); i++) {
            System.out.println(i + 1 + ")" + musicCollection.getSong().get(i).toString());
        }
    }
}
