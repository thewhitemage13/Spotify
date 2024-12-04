package org.spotify.db.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spotify.db.util.HibernateUtil;
import org.spotify.entities.MusicCollection;
import org.spotify.entities.Performer;
import org.spotify.entities.Song;

import java.util.List;

/**
 * Data Access Object (DAO) for performing CRUD operations on {@link MusicCollection} entities.
 * <p>
 * The {@code MusicCollectionDAO} class interacts with the database to perform create, read, update,
 * and delete (CRUD) operations for {@link MusicCollection} objects. It uses Hibernate as the ORM framework
 * for session management and transactions.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class MusicCollectionDAO implements Repository<MusicCollection> {

    /**
     * The {@link SessionFactory} instance used for creating and managing Hibernate sessions.
     * <p>
     * The {@code sessionFactory} is used to obtain sessions for performing CRUD operations
     * on {@link MusicCollection} entities and managing transactions.
     * </p>
     */
    private final SessionFactory sessionFactory;

    /**
     * Constructs a {@code MusicCollectionDAO} using the {@link HibernateUtil} to get the session factory.
     * This constructor initializes the sessionFactory to be used for database operations.
     */
    public MusicCollectionDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    /**
     * Saves a new {@link MusicCollection} to the database.
     * <p>
     * This method begins a transaction, saves the provided music collection, and commits the transaction.
     * If an error occurs, the transaction is rolled back, and an exception is thrown.
     * </p>
     *
     * @param collection the {@link MusicCollection} to be saved
     * @throws RuntimeException if an error occurs during the save operation
     */
    @Override
    public void save(MusicCollection collection) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(collection);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving music collection: " + e.getMessage());
        }
    }

    /**
     * Updates an existing {@link MusicCollection} in the database.
     * <p>
     * This method begins a transaction, updates the provided music collection, and commits the transaction.
     * If an error occurs, the transaction is rolled back, and an exception is thrown.
     * </p>
     *
     * @param collection the {@link MusicCollection} to be updated
     * @throws RuntimeException if an error occurs during the update operation
     */
    @Override
    public void update(MusicCollection collection) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(collection);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while updating music collection: " + e.getMessage());
        }
    }

    /**
     * Deletes a {@link MusicCollection} from the database.
     * <p>
     * This method begins a transaction, deletes the provided music collection, and commits the transaction.
     * If an error occurs, the transaction is rolled back, and an exception is thrown.
     * </p>
     *
     * @param collection the {@link MusicCollection} to be deleted
     * @throws RuntimeException if an error occurs during the delete operation
     */
    @Override
    public void delete(MusicCollection collection) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(collection);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while deleting music collection: " + e.getMessage());
        }
    }

    /**
     * Finds and returns all {@link MusicCollection} entities from the database.
     * <p>
     * This method begins a transaction, retrieves all music collections, initializes their associated
     * {@link Performer} and {@link Song} objects, and commits the transaction. If an error occurs,
     * an exception is thrown.
     * </p>
     *
     * @return a list of all {@link MusicCollection} objects
     * @throws RuntimeException if an error occurs during the find operation
     */
    @Override
    public List<MusicCollection> findAll() {
        List<MusicCollection> collections;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            collections = session.createQuery("from MusicCollection", MusicCollection.class).list();
            collections.forEach(collection -> {
                Hibernate.initialize(collection.getPerformer());
                Hibernate.initialize(collection.getSong());
            });
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while finding all music collections: " + e.getMessage());
        }
        return collections;
    }

    /**
     * Finds and returns a {@link MusicCollection} by its ID from the database.
     * <p>
     * This method begins a transaction, retrieves the music collection by ID, initializes its associated
     * {@link Performer} and {@link Song} objects, and commits the transaction. If an error occurs,
     * an exception is thrown.
     * </p>
     *
     * @param id the ID of the {@link MusicCollection} to be found
     * @return the {@link MusicCollection} object with the specified ID, or {@code null} if not found
     * @throws RuntimeException if an error occurs during the find operation
     */
    @Override
    public MusicCollection findById(Long id) {
        MusicCollection collection = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            collection = session.get(MusicCollection.class, id);
            if (collection != null) {
                Hibernate.initialize(collection.getPerformer());
                Hibernate.initialize(collection.getSong());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while finding music collection by ID: " + e.getMessage());
        }
        return collection;
    }
}
