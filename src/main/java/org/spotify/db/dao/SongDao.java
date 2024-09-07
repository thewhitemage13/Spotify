package org.spotify.db.dao;

import lombok.Cleanup;
import org.spotify.db.util.HibernateUtil;
import org.spotify.entities.Song;

import java.util.Optional;

public class SongDao {

    public void saveSong(Song song) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(song);
            session.getTransaction().commit();
        }
    }

    public void deleteSong(Song song) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(song);
            session.getTransaction().commit();
        }
    }

    public Optional<Song> findSongById(Long id) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            var query = session.createQuery("from Song s where s.song_id = :id", Song.class);
            query.setParameter("id", id);
            Song song = query.uniqueResult();
            session.getTransaction().commit();
            return Optional.ofNullable(song);
        }
    }

    public void deleteSongById(Long id) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            var query = session.createQuery("delete from Song s where s.songId = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
