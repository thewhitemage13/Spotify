package org.spotify.players;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.spotify.entities.MusicCollection;
import org.spotify.entities.Song;
import org.spotify.services.MusicCollectionService;
import org.spotify.services.SongService;

import java.io.*;
import java.util.Scanner;

public class ConsolePlayer {
    private final SongService songService = new SongService();
    private final MusicCollectionService musicCollectionService = new MusicCollectionService();
    private final Scanner scanner = new Scanner(System.in);

    public void playMusicCollection() {
        System.out.print("Enter Music Collection Id: ");
        Long musicCollectionId = scanner.nextLong();
        MusicCollection musicCollection = musicCollectionService.findByMusicCollectionId(musicCollectionId);

        for (int i = 0; i < musicCollection.getSong().size(); i++) {
            System.out.print("There's a song playing right now: " + musicCollection.getSong().get(i).getName());
            playMusic(musicCollection.getSong().get(i));
        }
    }

    public void playMusic(Song song){
        playerProcessor(song);
    }

    public void playMusic(){
        System.out.print("Enter song Id: ");
        Long songId = scanner.nextLong();
        Song song = songService.findSongById(songId);
        playerProcessor(song);
    }

    private void playerProcessor(Song song) {
        try (FileInputStream fileInputStream = new FileInputStream(song.getFilePath())) {
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
