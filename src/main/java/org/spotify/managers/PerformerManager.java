package org.spotify.managers;

import org.spotify.operations.AddPerformer;
import org.spotify.operations.DeletePerformer;
import org.spotify.operations.PerformerPrinter;
import org.spotify.operations.UpdatePerformer;

public class PerformerManager {
    private final AddPerformer addPerformer = new AddPerformer();
    private final PerformerPrinter performerPrinter = new PerformerPrinter();
    private final DeletePerformer deletePerformer = new DeletePerformer();
    private final UpdatePerformer updatePerformer = new UpdatePerformer();

    public void add() {
        addPerformer.add();
    }

    public void print() {
        performerPrinter.print();
    }

    public void delete() {
        deletePerformer.delete();
    }

    public void update() {
        updatePerformer.update();
    }
}
