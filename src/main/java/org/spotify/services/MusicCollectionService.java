package org.spotify.services;

import org.spotify.db.dao.MusicCollectionDao;
import org.spotify.entities.MusicCollection;
import org.spotify.exceptions.MusicCollectionNotFoundException;

public class MusicCollectionService {
    private final MusicCollectionDao musicCollectionDao = new MusicCollectionDao();

    public MusicCollection findByMusicCollectionId(Long musicCollectionId) {
        return musicCollectionDao
                .findMusicCollectionById(musicCollectionId)
                .orElseThrow(() -> new MusicCollectionNotFoundException("Music Collection with id = %s Not Found"
                        .formatted(musicCollectionId)));
    }
}
