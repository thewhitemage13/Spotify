package org.spotify.services;

import org.spotify.db.dao.PerformerDao;
import org.spotify.entities.Performer;

public class PerformerService {
    private final PerformerDao performerDao = new PerformerDao();

    public Performer findPerformerByName(String name) {
        return performerDao.findPerformerByName(name);
    }

    public void savePerformer(Performer performer) {
        performerDao.savePerformer(performer);
    }
}
