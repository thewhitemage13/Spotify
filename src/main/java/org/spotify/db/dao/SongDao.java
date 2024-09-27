package org.spotify.db.dao;

import org.spotify.db.util.HibernateUtil;
import org.spotify.entities.Song;

public class SongDao {

    public void save(Song song) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(song);
            session.getTransaction().commit();
        }
    }

    public void delete(Song song) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(song);
            session.getTransaction().commit();
        }
    }

    public Song findById(Long id) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            var query = session.createQuery("from Song s where s.song_id = :id", Song.class);
            query.setParameter("id", id);
            Song song = query.uniqueResult();
            session.getTransaction().commit();
            return song;
        }
    }

    public void deleteById(Long id) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            var query = session.createQuery("delete from Song s where s.song_id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
