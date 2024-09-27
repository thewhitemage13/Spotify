package org.spotify.services;

import org.spotify.db.dao.SongDao;
import org.spotify.entities.Song;

public class SongService {
    private final SongDao songDao = new SongDao();

    public Song findSongById(Long songId) {
         Song song = songDao.findById(songId);
         if (song == null) {
             return null;
         }
         return song;
    }

    public void save(Song song) {
        songDao.save(song);
    }

    public void delete(Song song) {
        songDao.delete(song);
    }

    public void deleteById(Long songId) {
        songDao.deleteById(songId);
    }
}
