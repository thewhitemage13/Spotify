package org.spotify.db.dao;

import org.hibernate.SessionFactory;
import org.spotify.db.util.HibernateUtil;
import org.spotify.entities.Performer;

public class PerformerDao {
    private static final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public void save(Performer performer) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(performer);
            session.getTransaction().commit();
        }
    }

    public void delete(Performer performer) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(performer);
            session.getTransaction().commit();
        }
    }

    public Performer findByName(String name) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var query = session.createQuery("SELECT p FROM Performer p LEFT JOIN FETCH p.musicCollection WHERE p.name = :name", Performer.class);
            query.setParameter("name", name);
            var performer = query.uniqueResult();
            session.getTransaction().commit();
            return performer;
        }
    }

    public void deleteByName(String name) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var query = session.createQuery("DELETE FROM Performer p WHERE p.name = :name");
            query.setParameter("name", name);
            int result = query.executeUpdate();
            session.getTransaction().commit();
            if (result == 0) {
                System.out.println("No performer found with name: " + name);
            }
        }
    }
}
