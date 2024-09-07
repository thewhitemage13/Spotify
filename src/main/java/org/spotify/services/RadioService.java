package org.spotify.services;

import org.spotify.db.dao.RadioDao;
import org.spotify.entities.Radio;
import org.spotify.exceptions.RadioNotFoundException;

public class RadioService {
    private final RadioDao radioDao = new RadioDao();

    public Radio findRadioById(Long radioId) {
        return radioDao.findRadioById(radioId)
                .orElseThrow(() -> new RadioNotFoundException("Radio with id = %s not found"
                        .formatted(radioId)));
    }
}
