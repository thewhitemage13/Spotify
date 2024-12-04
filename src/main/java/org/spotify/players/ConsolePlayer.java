package org.spotify.players;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.spotify.entities.MusicCollection;
import org.spotify.entities.Song;
import org.spotify.services.interfaces.Service;

import java.io.*;
import java.util.Scanner;

/**
 * Class responsible for playing music (songs and music collections) through the console.
 * <p>
 * This class provides methods to play individual songs or all songs in a music collection.
 * It uses the {@link javazoom.jl.player.Player} to handle the playback of MP3 files.
 * </p>
 *
 * The class allows users to play specific songs by their ID or play all songs in a music collection.
 * It also provides functionality to stop the playback by pressing the Enter key during playback.
 *
 * <p>
 * It handles the entire process of loading, playing, and controlling the playback of songs from files stored in the system.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class ConsolePlayer {
    private final Service<Song> songService;
    private final Service<MusicCollection> musicCollectionService;
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a {@link ConsolePlayer} with the specified services for songs and music collections.
     *
     * @param songService the service to manage songs
     * @param musicCollectionService the service to manage music collections
     */
    public ConsolePlayer(Service<Song> songService, Service<MusicCollection> musicCollectionService) {
        this.songService = songService;
        this.musicCollectionService = musicCollectionService;
    }

    /**
     * Plays all the songs in a music collection.
     * <p>
     * Prompts the user for a music collection ID, retrieves the corresponding music collection,
     * and plays each song in the collection sequentially.
     * </p>
     * If any errors occur while trying to play a song (e.g., file not found), they are logged and the
     * process continues with the next song in the collection.
     */
    public void playMusicCollection() {
        System.out.print("Enter Music Collection Id: ");
        Long musicCollectionId = scanner.nextLong();
        MusicCollection musicCollection = musicCollectionService.findById(musicCollectionId);

        for (int i = 0; i < musicCollection.getSong().size(); i++) {
            System.out.print("There's a song playing right now: " + musicCollection.getSong().get(i).getName());
            playMusic(musicCollection.getSong().get(i));
        }
    }

    /**
     * Plays a specific song.
     * <p>
     * Prompts the user for a song ID, retrieves the corresponding song, and plays it.
     * </p>
     *
     * @param song the {@link Song} to be played
     */
    public void playMusic(Song song){
        playerProcessor(song);
    }

    /**
     * Plays a specific song by its ID.
     * <p>
     * Prompts the user for a song ID, retrieves the corresponding song, and plays it.
     * </p>
     */
    public void playMusic(){
        System.out.print("Enter song Id: ");
        Long songId = scanner.nextLong();
        Song song = songService.findById(songId);
        System.out.println(song);
        playerProcessor(song);
    }

    /**
     * Processes the playback of a song.
     * <p>
     * This method uses the {@link Player} class from the {@code javazoom} library to play an MP3 file.
     * It handles playback in a separate thread, allowing the user to stop the playback by pressing Enter.
     * </p>
     *
     * @param song the {@link Song} to be played
     */
    private void playerProcessor(Song song) {
        try (FileInputStream fileInputStream = new FileInputStream(song.getFilePath())) {
            Player player = new Player(fileInputStream);
            System.out.println("Playback has started. Press Enter to stop.");

            Thread playThread = new Thread(() -> {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    System.err.println("Audio playback error.");
                    e.printStackTrace();
                }
            });

            playThread.start();
            scanner.nextLine();
            scanner.nextLine();
            playThread.join();

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
        } catch (InterruptedException e) {
            System.err.println("Playback interrupted.");
            e.printStackTrace();
        }
    }

}
