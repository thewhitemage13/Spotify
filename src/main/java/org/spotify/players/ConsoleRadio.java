package org.spotify.players;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;
import org.spotify.entities.Radio;
import org.spotify.services.interfaces.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Class responsible for handling the playback of radio stations through the console.
 * <p>
 * This class allows the user to play a radio stream by specifying a radio station's ID, retrieving the associated URL,
 * and streaming the content using the {@link javazoom.jl.player.advanced.AdvancedPlayer}.
 * </p>
 * <p>
 * It uses {@link AdvancedPlayer} to handle the playback and streams the content from the provided URL. The user can start
 * and stop the playback from the console, and the playback is monitored using a listener.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class ConsoleRadio {
    private final Service<Radio> radioService;

    /**
     * Constructs a {@link ConsoleRadio} instance with the specified service for managing radio stations.
     *
     * @param radioService the service to manage radio stations
     */
    public ConsoleRadio(Service<Radio> radioService) {
        this.radioService = radioService;
    }

    /**
     * Starts the playback of a radio station.
     * <p>
     * This method prompts the user to enter a radio station ID, retrieves the corresponding radio station from the service,
     * and plays the radio stream from the URL associated with the radio station. If the URL is invalid or the radio is not found,
     * appropriate error messages are displayed.
     * </p>
     * <p>
     * The method uses {@link AdvancedPlayer} to stream the audio from the radio station's URL and provides a playback listener
     * to notify when playback finishes.
     * </p>
     */
    public void playRadio() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Radio Id: ");
        Long radioId = scanner.nextLong();
        scanner.nextLine();

        Radio radio = radioService.findById(radioId);
        if (radio == null) {
            System.out.println("Radio with ID " + radioId + " not found!");
            return;
        }

        String radioUrl = radio.getRadioUrl();
        if (radioUrl == null || radioUrl.isEmpty()) {
            System.out.println("Invalid radio URL for Radio ID: " + radioId);
            return;
        }

        System.out.println("Starting playback for Radio: " + radio.getRadioName() + " (" + radioUrl + ")");

        try (InputStream inputStream = new BufferedInputStream(new URL(radioUrl).openStream())) {
            AdvancedPlayer player = new AdvancedPlayer(inputStream);

            Thread playbackThread = new Thread(() -> {
                try {
                    player.setPlayBackListener(new PlaybackListener() {
                        @Override
                        public void playbackFinished(PlaybackEvent evt) {
                            System.out.println("Playback finished.");
                        }
                    });
                    player.play();
                } catch (JavaLayerException e) {
                    System.err.println("Audio playback error.");
                    e.printStackTrace();
                }
            });

            playbackThread.start();
            System.out.println("Playback has started. Press Enter to stop.");
            scanner.nextLine();

            player.close();
            playbackThread.interrupt();

        } catch (IOException e) {
            System.err.println("I/O error during radio playback.");
            e.printStackTrace();
        } catch (JavaLayerException e) {
            System.err.println("Audio playback error.");
            e.printStackTrace();
        }
    }
}
