package org.spotify.services;

import org.spotify.db.dao.MusicCollectionDao;
import org.spotify.entities.MusicCollection;


public class MusicCollectionService {
    private final MusicCollectionDao musicCollectionDao = new MusicCollectionDao();

    public MusicCollection findById(Long id) {
        MusicCollection musicCollection = musicCollectionDao.findById(id);
        if (musicCollection == null) {
            return null;
        }
        return musicCollection;
    }

    public void save(MusicCollection musicCollection) {
        musicCollectionDao.save(musicCollection);
    }

    public void delete(MusicCollection musicCollection) {
        musicCollectionDao.delete(musicCollection);
    }

    public void deleteMusicCollectionById(Long id) {
        MusicCollection musicCollection = findById(id);
        musicCollectionDao.deleteById(musicCollection.getMusic_collection_id());
    }
}
