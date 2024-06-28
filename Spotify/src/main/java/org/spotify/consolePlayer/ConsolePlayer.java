package org.spotify.consolePlayer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.spotify.entity.MusicCollection;
import org.spotify.interfaces.Playable;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
// Класс для проигрывания музыки
// Реализует interface Playable
public class ConsolePlayer implements Playable<MusicCollection> {
    // Метод PlayTheLastAddedSong позваляет воспроизвести последнюю добавленную песню в альбом
    @Override
    public void PlayTheLastAddedSong(MusicCollection musicCollection) {
        for (int i = 0; i < musicCollection.getSong().size(); i++) {
            System.out.println("There's a song playing right now: " + musicCollection.getSong().get(i).getName());
            playMusic(musicCollection.getSong().get(i).getFilePath());
        }
    }
    // Метод playFromPC позваляет воспроизвести песню с нашего компьютера
    // Пользователю нужно указать путь к файлу
    @Override
    public void playFromPC() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter File Path: ");
        String filePath = scanner.nextLine();
        playMusic(filePath);
    }
    // Метод playMusicFromInternet позволяет воспроизвести музыку с интернета
    // Пользователю нужно указать ссылку на композицию
    @Override
    public void playMusicFromInternet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the URL of the MP3 file:");
        String fileUrl = scanner.nextLine();

        try {
            // открытие соединения с URL
            URL url = new URL(fileUrl);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

            // создание и запуск плеера
            Player player = new Player(inputStream);
            System.out.println("Playback has started. Press Enter to stop.");
            new Thread(() -> {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    System.err.println("Audio playback error.");
                    e.printStackTrace();
                }
            }).start();

            scanner.nextLine();
            player.close();
        } catch (IOException e) {
            System.err.println("I/O error.");
            e.printStackTrace();
        } catch (JavaLayerException e) {
            System.err.println("Audio playback error.");
            e.printStackTrace();
        }
    }
    // Метод playMusic реализует воспроизведение музыки для мутодов PlayTheLastAddedSong, playFromPC
    private void playMusic(String filePath){
        Scanner scanner = new Scanner(System.in);
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            Player player = new Player(fileInputStream);
            System.out.println("Playback has started. Press Enter to stop.");
            new Thread(() -> {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    System.err.println("Audio playback error.");
                    e.printStackTrace();
                }
            }).start();

            scanner.nextLine();
            player.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            e.printStackTrace();
        } catch (JavaLayerException e) {
            System.err.println("Audio playback error.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O error.");
            e.printStackTrace();
        }
    }
}
