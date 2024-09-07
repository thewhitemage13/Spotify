package org.spotify.managers;

import org.spotify.players.ConsolePlayer;
import org.spotify.players.ConsoleRadio;

public class PlayerManager {
    private final ConsolePlayer consolePlayer = new ConsolePlayer();
    private final ConsoleRadio consoleRadio = new ConsoleRadio();

    public void playMusic() {
        consolePlayer.playMusic();
    }

    public void playMusicCollection() {
        consolePlayer.playMusicCollection();
    }

    public void playRadio() {
        consoleRadio.playRadio();
    }

}
