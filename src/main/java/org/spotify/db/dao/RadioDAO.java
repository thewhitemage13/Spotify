package org.spotify.db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spotify.db.util.HibernateUtil;
import org.spotify.entities.Radio;

import java.util.List;

/**
 * Data Access Object (DAO) for performing CRUD operations on {@link Radio} entities.
 * <p>
 * The {@code RadioDAO} class provides methods to interact with the database to perform
 * create, read, update, and delete (CRUD) operations for {@link Radio} objects using Hibernate ORM.
 * </p>
 * <p>
 * This class abstracts the interaction with the database for {@link Radio} entities,
 * allowing for easy and efficient management of radio data in a persistent storage.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class RadioDAO implements Repository<Radio>{

    /**
     * The {@link SessionFactory} instance used to create Hibernate {@link Session} objects.
     * <p>
     * The {@code sessionFactory} is responsible for managing Hibernate sessions, which are used
     * to interact with the database. It is initialized via the {@link HibernateUtil} class.
     * </p>
     */
    private final SessionFactory sessionFactory;

    /**
     * Constructs a {@code RadioDAO} using the {@link HibernateUtil} to get the session factory.
     * <p>
     * This constructor initializes the session factory that will be used to create sessions
     * for interacting with the database.
     * </p>
     */
    public RadioDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    /**
     * Saves a new {@link Radio} entity to the database.
     * <p>
     * This method begins a transaction, saves the provided radio, and commits the transaction.
     * If an error occurs, the transaction is rolled back, and an exception is thrown.
     * </p>
     *
     * @param radio the {@link Radio} to be saved
     */
    @Override
    public void save(Radio radio) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(radio);
            session.getTransaction().commit();
        }
    }

    /**
     * Updates an existing {@link Radio} entity in the database.
     * <p>
     * This method begins a transaction, updates the provided radio, and commits the transaction.
     * If an error occurs, the transaction is rolled back, and an exception is thrown.
     * </p>
     *
     * @param radio the {@link Radio} to be updated
     */
    @Override
    public void update(Radio radio) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(radio);
            session.getTransaction().commit();
        }
    }

    /**
     * Deletes a {@link Radio} from the database.
     * <p>
     * This method begins a transaction, deletes the provided radio, and commits the transaction.
     * If an error occurs, the transaction is rolled back, and an exception is thrown.
     * </p>
     *
     * @param radio the {@link Radio} to be deleted
     */
    @Override
    public void delete(Radio radio) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(radio);
            session.getTransaction().commit();
        }
    }

    /**
     * Finds and returns a {@link Radio} entity by its ID from the database.
     * <p>
     * This method begins a transaction, retrieves the radio by ID, and commits the transaction.
     * If an error occurs, an exception is thrown.
     * </p>
     *
     * @param id the ID of the {@link Radio} to be found
     * @return the {@link Radio} object with the specified ID, or {@code null} if not found
     */
    @Override
    public Radio findById(Long id) {
        Radio radio = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            radio = session.get(Radio.class, id);
            session.getTransaction().commit();
        }
        return radio;
    }

    /**
     * Finds and returns all {@link Radio} entities from the database.
     * <p>
     * This method begins a transaction, retrieves all radios, and commits the transaction.
     * If an error occurs, an exception is thrown.
     * </p>
     *
     * @return a list of all {@link Radio} objects
     */
    @Override
    public List<Radio> findAll() {
        List<Radio> radios;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            radios = session.createQuery("from Radio", Radio.class).list();
            session.getTransaction().commit();
        }
        return radios;
    }
}
