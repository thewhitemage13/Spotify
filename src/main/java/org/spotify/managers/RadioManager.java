package org.spotify.managers;

import org.spotify.operations.AddRadio;
import org.spotify.operations.DeleteRadio;
import org.spotify.operations.PrintRadio;
import org.spotify.operations.UpdateRadio;

public class RadioManager {
    private final AddRadio addRadio = new AddRadio();
    private final PrintRadio printRadio = new PrintRadio();
    private final DeleteRadio deleteRadio = new DeleteRadio();
    private final UpdateRadio updateRadio = new UpdateRadio();

    public void add() {
        addRadio.add();
    }

    public void print() {
        printRadio.print();
    }

    public void delete() {
        deleteRadio.delete();
    }

    public void update() {
        updateRadio.update();
    }

}
