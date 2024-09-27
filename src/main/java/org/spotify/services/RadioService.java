package org.spotify.services;

import org.spotify.db.dao.RadioDao;
import org.spotify.entities.Radio;

public class RadioService {
    private final RadioDao radioDao = new RadioDao();

    public Radio findById(Long radioId) {
        Radio radio = radioDao.findById(radioId);
        if (radio == null) {
            return null;
        }
        return radio;
    }

    public void save(Radio radio) {
        radioDao.save(radio);
    }

    public void deleteById(Long radioId) {
        radioDao.deleteById(radioId);
    }
}
