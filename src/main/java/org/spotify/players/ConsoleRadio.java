package org.spotify.players;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;
import org.spotify.entities.Radio;
import org.spotify.managers.RadioManager;
import org.spotify.services.RadioService;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ConsoleRadio {
    private final RadioService radioService = new RadioService();

    public void playRadio() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Radio Id: ");
        Long radioId = scanner.nextLong();

        Radio radio = radioService.findRadioById(radioId);

        try {
            URL url = new URL(radio.getRadioUrl());
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
