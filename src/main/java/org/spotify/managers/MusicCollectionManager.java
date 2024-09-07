package org.spotify.managers;

import org.spotify.operations.AddMusicCollection;
import org.spotify.operations.DeleteMusicCollection;
import org.spotify.operations.MusicCollectionPrinter;
import org.spotify.operations.UpdateMusicCollection;

public class MusicCollectionManager {
    private final MusicCollectionPrinter musicCollectionPrinter = new MusicCollectionPrinter();
    private final AddMusicCollection addMusicCollection = new AddMusicCollection();
    private final DeleteMusicCollection deleteMusicCollection = new DeleteMusicCollection();
    private final UpdateMusicCollection updateMusicCollection = new UpdateMusicCollection();

    public void add() {
        addMusicCollection.add();
    }

    public void print() {
        musicCollectionPrinter.print();
    }

    public void delete() {
        deleteMusicCollection.delete();
    }

    public void update() {
        updateMusicCollection.update();
    }
}
