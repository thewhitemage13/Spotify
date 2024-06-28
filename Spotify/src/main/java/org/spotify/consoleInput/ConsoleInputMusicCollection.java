package org.spotify.consoleInput;

import org.spotify.dataBase.Dao.MusicCollectionDao;
import org.spotify.entity.MusicCollection;
import org.spotify.entity.Performer;
import org.spotify.entity.Song;
import org.spotify.interfaces.InputMusicCollection;
import org.spotify.interfaces.TypeOfCollection;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;
// Класс для заполнения информации об музкальной коллекции с консоли + запись информации, внасимую пользователем, в БД
// А так же класс реализует interface InputMusicCollection
public class ConsoleInputMusicCollection implements InputMusicCollection<MusicCollection, Performer> {
    private MusicCollectionDao musicCollectionDao = new MusicCollectionDao();
    @Override
    public MusicCollection input(MusicCollection musicCollection, Performer performer) {
        // Тип музыкальной коллекции
        TypeOfCollection[] types = TypeOfCollection.values();
        Scanner scanner = new Scanner(System.in);
        // Вводим имя нашего альбома
        System.out.print("Please enter the name of the album: ");
        String name = scanner.nextLine();
        musicCollection.setName(name);

        System.out.print("All type of Music Collection: ");
        System.out.print(Arrays.toString(types) + "\n");
        // Вводим тип музыкальной музыкальной коллекции
        System.out.print("Enter the type of the music collection: ");
        TypeOfCollection typeOfCollection = TypeOfCollection.valueOf(scanner.nextLine());
        musicCollection.setTypeOfCollection(typeOfCollection);
        // Вводим дату релиза
        LocalDate releaseDate = null;
        while (releaseDate == null) {
            System.out.print("Please enter the release date (yyyy-MM-dd): ");
            String dateInput = scanner.nextLine();
            try {
                releaseDate = LocalDate.parse(dateInput);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            }
        }
        // Сохраняем дату
        musicCollection.setReleaseDate(releaseDate);
        // Сохраняем исполнителя
        musicCollection.setPerformer(performer);
        // Добавление песни в альбом
        addSongsToAlbum(musicCollection);
        // Запись данных в БД
        musicCollectionDao.databaseEntry(musicCollection);
        return musicCollection;
    }
    // Метод для добавления песни в альбом
    private void addSongsToAlbum(MusicCollection musicCollection) {
        Scanner scanner = new Scanner(System.in);
        String addMore;
        do {
            System.out.println("Add a new song to the album:");
            Song song = new Song();

            ConsoleInputSong songInput = new ConsoleInputSong();
            songInput.input(song);

            musicCollection.add(song);

            System.out.print("Do you want to add another song? (yes/no): ");
            addMore = scanner.nextLine().trim().toLowerCase();
        } while (addMore.equals("yes"));
    }
}
