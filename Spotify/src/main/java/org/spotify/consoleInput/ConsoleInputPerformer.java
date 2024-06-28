package org.spotify.consoleInput;

import org.spotify.dataBase.Dao.PerformerDao;
import org.spotify.enums.Genre;
import org.spotify.entity.Performer;
import org.spotify.interfaces.Input;

import java.util.Arrays;
import java.util.Scanner;
// Класс для заполнения информации об музкальном исполнители с консоли + запись информации, внасимую пользователем, в БД
// А так же класс реализует interface Input
public class ConsoleInputPerformer implements Input<Performer> {
    PerformerDao performerDao = new PerformerDao();
    public Performer input(Performer performer) {
        Scanner scanner = new Scanner(System.in);
        // Жарны песни
        Genre[] genres = Genre.values();
        // Вводим имя исполнителя
        System.out.print("Enter performer name: ");
        String name = scanner.nextLine();
        performer.setName(name);
        // Все жанры
        System.out.print("All genre: ");
        System.out.print(Arrays.toString(genres) + "\n");
        // Вводим жанр исполнителя
        System.out.print("Enter performer genre: ");
        Genre genre = Genre.valueOf(scanner.nextLine());
        performer.setGenre(genre);
        // Запись данных в БД
        performerDao.databaseEntry(performer);

        return performer;
    }
}