package org.spotify.db.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.spotify.db.util.HibernateUtil;
import org.spotify.entities.MusicCollection;

public class MusicCollectionDao {

    public void save(MusicCollection musicCollection) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(musicCollection);
            session.getTransaction().commit();
        }
    }

    public void delete(MusicCollection musicCollection) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(musicCollection);
            session.getTransaction().commit();
        }
    }

    public MusicCollection findById(Long id) {
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            MusicCollection musicCollection = session.get(MusicCollection.class, id);
            Hibernate.initialize(musicCollection.getSong());
            tx.commit();
            return musicCollection;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void deleteById(Long id) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            var query = session.createQuery("delete from MusicCollection where music_collection_id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
