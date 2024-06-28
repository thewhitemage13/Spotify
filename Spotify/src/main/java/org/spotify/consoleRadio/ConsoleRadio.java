package org.spotify.consoleRadio;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;
import org.spotify.interfaces.Radio;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
// Класс для радио
public class ConsoleRadio implements Radio {
    // Метод playRadio(String radioUrl) подключается к радио станции по ссылке, которую мы устанавлиаем в ConsoleRadioMenu
    @Override
    public void playRadio(String radioUrl) {
        Scanner scanner = new Scanner(System.in);

        try {
            URL url = new URL(radioUrl);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

            AdvancedPlayer player = new AdvancedPlayer(inputStream);
            System.out.println("Playback has started. Press Enter to stop.");
            new Thread(() -> {
                try {
                    player.setPlayBackListener(new PlaybackListener() {
                        @Override
                        public void playbackFinished(PlaybackEvent evt) {
                        }
                    });
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
    // Метод playRadio подключается к радио станции по ссылке, которую укажет пользователь
    @Override
    public void playRadio() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter link: ");
        String radioUrl = scanner.nextLine();

        try {
            URL url = new URL(radioUrl);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

            AdvancedPlayer player = new AdvancedPlayer(inputStream);
            System.out.println("Playback has started. Press Enter to stop.");
            new Thread(() -> {
                try {
                    player.setPlayBackListener(new PlaybackListener() {
                        @Override
                        public void playbackFinished(PlaybackEvent evt) {
                        }
                    });
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

}
