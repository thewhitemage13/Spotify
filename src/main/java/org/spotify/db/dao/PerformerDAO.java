package org.spotify.db.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spotify.db.util.HibernateUtil;
import org.spotify.entities.Performer;

import java.util.List;

/**
 * Data Access Object (DAO) for performing CRUD operations on {@link Performer} entities.
 * <p>
 * The {@code PerformerDAO} class is responsible for interacting with the database to perform create, read, update,
 * and delete (CRUD) operations for {@link Performer} objects using Hibernate ORM.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class PerformerDAO implements Repository<Performer> {

    /**
     * The {@link SessionFactory} instance used to create Hibernate {@link Session} objects.
     * <p>
     * The {@code sessionFactory} is responsible for managing Hibernate sessions that allow interaction
     * with the database to perform CRUD operations on {@link Performer} entities. It is initialized using
     * the {@link HibernateUtil} class for session management.
     * </p>
     */
    private final SessionFactory sessionFactory;

    /**
     * Constructs a {@code PerformerDAO} using the {@link HibernateUtil} to get the session factory.
     * <p>
     * This constructor initializes the session factory to be used for database interactions.
     * </p>
     */
    public PerformerDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    /**
     * Saves a new {@link Performer} entity to the database.
     * <p>
     * This method begins a transaction, saves the provided performer, and commits the transaction.
     * If an error occurs, the transaction is rolled back, and an exception is thrown.
     * </p>
     *
     * @param performer the {@link Performer} to be saved
     * @throws RuntimeException if an error occurs during the save operation
     */
    @Override
    public void save(Performer performer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(performer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving performer: " + e.getMessage());
        }
    }

    /**
     * Finds and returns a {@link Performer} by its ID from the database.
     * <p>
     * This method begins a transaction, retrieves the performer by ID, initializes its associated
     * {@link org.spotify.entities.MusicCollection} and {@link org.spotify.entities.Song} objects, and commits the transaction.
     * If an error occurs, an exception is thrown.
     * </p>
     *
     * @param id the ID of the {@link Performer} to be found
     * @return the {@link Performer} object with the specified ID, or {@code null} if not found
     * @throws RuntimeException if an error occurs during the find operation
     */
    @Override
    public Performer findById(Long id) {
        Performer performer = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            performer = session.get(Performer.class, id);
            if (performer != null) {
                Hibernate.initialize(performer.getMusicCollection());
                Hibernate.initialize(performer.getSongs());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while finding performer by ID: " + e.getMessage());
        }
        return performer;
    }

    /**
     * Finds and returns all {@link Performer} entities from the database.
     * <p>
     * This method begins a transaction, retrieves all performers, initializes their associated
     * {@link org.spotify.entities.MusicCollection} and {@link org.spotify.entities.Song} objects, and commits the transaction.
     * If an error occurs, an exception is thrown.
     * </p>
     *
     * @return a list of all {@link Performer} objects
     * @throws RuntimeException if an error occurs during the find operation
     */
    @Override
    public List<Performer> findAll() {
        List<Performer> performers;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            performers = session.createQuery("from Performer", Performer.class).list();
            performers.forEach(performer -> {
                Hibernate.initialize(performer.getMusicCollection());
                Hibernate.initialize(performer.getSongs());
            });
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while finding all performers: " + e.getMessage());
        }
        return performers;
    }

    /**
     * Deletes a {@link Performer} from the database.
     * <p>
     * This method begins a transaction, deletes the provided performer, and commits the transaction.
     * If an error occurs, the transaction is rolled back, and an exception is thrown.
     * </p>
     *
     * @param performer the {@link Performer} to be deleted
     * @throws RuntimeException if an error occurs during the delete operation
     */
    @Override
    public void delete(Performer performer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(performer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while deleting performer: " + e.getMessage());
        }
    }

    /**
     * Updates an existing {@link Performer} entity in the database.
     * <p>
     * This method begins a transaction, updates the provided performer, and commits the transaction.
     * If an error occurs, the transaction is rolled back, and an exception is thrown.
     * </p>
     *
     * @param performer the {@link Performer} to be updated
     * @throws RuntimeException if an error occurs during the update operation
     */
    @Override
    public void update(Performer performer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(performer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while updating performer: " + e.getMessage());
        }
    }
}
