package org.spotify.consoleInput;

import org.spotify.dataBase.Dao.SongDao;
import org.spotify.enums.Genre;
import org.spotify.entity.Song;
import org.spotify.enums.TypeOfSong;
import org.spotify.interfaces.Input;

import java.util.Arrays;
import java.util.Scanner;
// Класс для заполнения информации об песне с консоли + запись информации, внасимую пользователем, в БД
// А так же класс реализует interface Input
public class ConsoleInputSong implements Input<Song> {
    SongDao songDao = new SongDao();
    @Override
    public Song input(Song song) {
        Scanner scanner = new Scanner(System.in);
        // Тип песни
        TypeOfSong[] typeOfSongs = TypeOfSong.values();
        // Жанр песни
        Genre[] genres = Genre.values();
        // Вводим имя песни
        System.out.print("Input name: ");
        String name = scanner.nextLine();
        song.setName(name);
        System.out.print("All type of song:");
        System.out.println(Arrays.toString(typeOfSongs));
        // Вводим тип песни
        System.out.print("Enter the type of song: ");
        TypeOfSong typeOfSong = TypeOfSong.valueOf(scanner.nextLine());
        song.setTypeOfSong(typeOfSong);
        // Вводим длинну песни в секудах
        System.out.print("Duration: ");
        int duration = scanner.nextInt();
        song.setDuration(duration);

        scanner.nextLine();
        // Вводим путь к файлу песни
        System.out.print("Enter path: ");
        String path = scanner.nextLine();
        song.setFilePath(path);

        System.out.print("All Genre: ");
        System.out.print(Arrays.toString(genres) + "\n");
        // Вводим жанр песни
        System.out.print("Enter song genre: ");
        Genre genre = Genre.valueOf(scanner.nextLine());
        song.setGenre(genre);

        // Запись данных в БД
        songDao.databaseEntry(song);

        return song;
    }
}
