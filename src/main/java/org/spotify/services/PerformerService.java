package org.spotify.services;

import org.spotify.db.dao.PerformerDao;
import org.spotify.entities.Performer;


public class PerformerService {
    private final PerformerDao performerDao = new PerformerDao();

    public Performer findByName(String name) {
        Performer performer = performerDao.findByName(name);
        if (performer == null) {
            return null;
        }
        return performer;
    }

    public void save(Performer performer) {
        performerDao.save(performer);
    }

    public void delete(Performer performer) {
        performerDao.delete(performer);
    }

    public void deleteByName(String name) {
        performerDao.deleteByName(name);
    }
}
