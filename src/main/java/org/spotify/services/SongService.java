package org.spotify.services;

import org.spotify.db.dao.SongDao;
import org.spotify.entities.Song;
import org.spotify.exceptions.SongNotFoundException;

public class SongService {
    private final SongDao songDao = new SongDao();

    public Song findSongById(Long songId) {
        return songDao.findSongById(songId)
                .orElseThrow(() -> new SongNotFoundException("Song with id = %s not found"
                        .formatted(songId)));
    }
}
