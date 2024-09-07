package org.spotify.db.dao;

import lombok.Cleanup;
import org.hibernate.Hibernate;
import org.spotify.db.util.HibernateUtil;
import org.spotify.entities.Performer;

public class PerformerDao {
    public void savePerformer(Performer performer) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(performer);
            session.getTransaction().commit();
        }
    }

    public void deletePerformer(Performer performer) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(performer);
            session.getTransaction().commit();
        }
    }

    public Performer findPerformerByName(String name) {
        try (var session = HibernateUtil.buildSessionFactory().openSession()) {
            session.beginTransaction();
            var query = session.createQuery("FROM Performer p WHERE p.name = :name", Performer.class);
            query.setParameter("name", name);
            var performer = query.uniqueResult();
            Hibernate.initialize(performer.getMusicCollection());
            session.getTransaction().commit();
            return performer;
        }
    }

    public void deletePerformerByName(String name) {
        Performer performer = findPerformerByName(name);
        if (performer != null) {
            try (var session = HibernateUtil.buildSessionFactory().openSession()) {
                session.beginTransaction();
                session.delete(performer);
                session.getTransaction().commit();
            }
        }
    }
}
