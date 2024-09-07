package org.spotify.managers;

import org.spotify.operations.AddSong;
import org.spotify.operations.DeleteSong;
import org.spotify.operations.SongPrinter;
import org.spotify.operations.UpdateSong;

public class SongManager {
    private final AddSong addSong = new AddSong();
    private final UpdateSong updateSong = new UpdateSong();
    private final DeleteSong deleteSong = new DeleteSong();
    private final SongPrinter songPrinter = new SongPrinter();

    public void add() {
        addSong.add();
    }

    public void update() {
        updateSong.update();
    }

    public void delete() {
        deleteSong.delete();
    }

    public void print() {
        songPrinter.print();
    }
}
