package org.spotify.consolePrinter;

import org.spotify.entity.Song;
import org.spotify.interfaces.Printer;
// Класс для вывода на консоль информации о песне
// Релизует interface Printer
public class ConsoleSongPrinter implements Printer<Song> {
    @Override
    public void print(Song song) {
        System.out.println("Name: " + song.getName());
        System.out.println("Type Of Song: " + song.getTypeOfSong());
        System.out.println("Duration: " + song.getDuration() + "sec.");
        System.out.println("Genre: " + song.getGenre());
    }
}
