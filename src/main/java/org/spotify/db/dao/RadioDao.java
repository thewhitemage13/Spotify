package org.spotify.db.dao;

import lombok.Cleanup;
import org.spotify.db.util.HibernateUtil;
import org.spotify.entities.Radio;

import java.util.Optional;

public class RadioDao {

    public void saveRadio(Radio radio) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(radio);
            session.getTransaction().commit();
        }
    }

    public void deleteRadioById(Long radioId) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            var query = session.createQuery("delete from Radio where radioId = :radioId");
            query.setParameter("radioId", radioId);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public Optional<Radio> findRadioById(Long radioId) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            var query = session.createQuery("from Radio where radioId = :radioId", Radio.class);
            query.setParameter("radioId", radioId);
            Radio radio = query.uniqueResult();
            session.getTransaction().commit();
            return Optional.ofNullable(radio);
        }
    }
}
