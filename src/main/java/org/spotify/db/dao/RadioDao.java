package org.spotify.db.dao;

import org.spotify.db.util.HibernateUtil;
import org.spotify.entities.Radio;

public class RadioDao {

    public void save(Radio radio) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(radio);
            session.getTransaction().commit();
        }
    }

    public void deleteById(Long radioId) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            var query = session.createQuery("delete from Radio where radioId = :radioId");
            query.setParameter("radioId", radioId);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public Radio findById(Long radioId) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            var query = session.createQuery("from Radio where radioId = :radioId", Radio.class);
            query.setParameter("radioId", radioId);
            Radio radio = query.uniqueResult();
            session.getTransaction().commit();
            return radio;
        }
    }
}
