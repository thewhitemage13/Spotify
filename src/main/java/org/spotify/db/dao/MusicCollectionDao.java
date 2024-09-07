package org.spotify.db.dao;

import lombok.Cleanup;
import org.hibernate.Hibernate;
import org.spotify.db.util.HibernateUtil;
import org.spotify.entities.MusicCollection;

import java.util.Optional;

public class MusicCollectionDao {

    public void saveMusicCollection(MusicCollection musicCollection) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(musicCollection);
            session.getTransaction().commit();
        }
    }

    public void deleteMusicCollection(MusicCollection musicCollection) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(musicCollection);
            session.getTransaction().commit();
        }
    }

    public Optional<MusicCollection> findMusicCollectionById(Long id) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            var query = session.createQuery("from MusicCollection where music_collection_id = :id", MusicCollection.class);
            query.setParameter("id", id);
            var musicCollection = query.uniqueResult();
            session.getTransaction().commit();
            return Optional.ofNullable(musicCollection);
        }
    }

    public void deleteMusicCollectionById(Long id) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            var query = session.createQuery("delete from MusicCollection where music_collection_id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
