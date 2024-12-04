package org.spotify.db.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spotify.db.util.HibernateUtil;
import org.spotify.entities.Song;

import java.util.List;

/**
 * Data Access Object (DAO) for performing CRUD operations on {@link Song} entities.
 * <p>
 * The {@code SongDAO} class interacts with the database to perform create, read, update,
 * and delete (CRUD) operations for {@link Song} objects. It uses Hibernate as the ORM framework
 * for session management and transactions.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class SongDAO implements Repository<Song> {

    /**
     * The {@link SessionFactory} instance used to create Hibernate {@link Session} objects.
     * <p>
     * The {@code sessionFactory} is responsible for managing Hibernate sessions, which are used
     * to interact with the database. It is initialized via the {@link HibernateUtil} class.
     * </p>
     */
    private final SessionFactory sessionFactory;

    /**
     * Constructs a {@code SongDAO} using the {@link HibernateUtil} to get the session factory.
     * <p>
     * This constructor initializes the session factory that will be used to create sessions
     * for interacting with the database.
     * </p>
     */
    public SongDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    /**
     * Saves a new {@link Song} to the database.
     * <p>
     * This method begins a transaction, saves the provided song, and commits the transaction.
     * If an error occurs, the transaction is rolled back, and an exception is thrown.
     * </p>
     *
     * @param song the {@link Song} to be saved
     * @throws RuntimeException if an error occurs during the save operation
     */
    @Override
    public void save(Song song) {
        executeTransaction(session -> session.save(song));
    }

    /**
     * Updates an existing {@link Song} in the database.
     * <p>
     * This method begins a transaction, updates the provided song, and commits the transaction.
     * If an error occurs, the transaction is rolled back, and an exception is thrown.
     * </p>
     *
     * @param song the {@link Song} to be updated
     * @throws RuntimeException if an error occurs during the update operation
     */
    @Override
    public void update(Song song) {
        executeTransaction(session -> session.update(song));
    }

    /**
     * Deletes a {@link Song} from the database.
     * <p>
     * This method begins a transaction, deletes the provided song, and commits the transaction.
     * If an error occurs, the transaction is rolled back, and an exception is thrown.
     * </p>
     *
     * @param song the {@link Song} to be deleted
     * @throws RuntimeException if an error occurs during the delete operation
     */
    @Override
    public void delete(Song song) {
        executeTransaction(session -> session.delete(song));
    }

    /**
     * Finds and returns a {@link Song} by its ID from the database.
     * <p>
     * This method begins a transaction, retrieves the song by ID, initializes its associated
     * {@link Song}#getPerformer() object, and commits the transaction. If an error occurs,
     * an exception is thrown.
     *
     * @param id the ID of the {@link Song} to be found
     * @return the {@link Song} object with the specified ID, or {@code null} if not found
     * @throws RuntimeException if an error occurs during the find operation
     */
    @Override
    public Song findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Song song = session.get(Song.class, id);
            if (song != null) {
                Hibernate.initialize(song.getPerformer());
            }
            return song;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding Song by ID: " + id, e);
        }
    }

    /**
     * Finds and returns all {@link Song} entities from the database.
     * <p>
     * This method begins a transaction, retrieves all songs, initializes their associated
     * {@link Song getPerformer()} objects, and commits the transaction. If an error occurs,
     * an exception is thrown.
     * </p>
     *
     * @return a list of all {@link Song} objects
     * @throws RuntimeException if an error occurs during the find operation
     */
    @Override
    public List<Song> findAll() {
        try (Session session = sessionFactory.openSession()) {
            List<Song> songs = session.createQuery("from Song", Song.class).list();
            songs.forEach(song -> Hibernate.initialize(song.getPerformer()));
            return songs;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding all Songs", e);
        }
    }

    /**
     * Executes a transaction involving a {@link Session}.
     * <p>
     * This private method is used to execute a database operation within a Hibernate transaction.
     * It wraps the transaction management (begin, commit) and ensures that the operation is executed
     * safely. Any operation that modifies the database can be passed as a {@code TransactionAction}.
     * </p>
     *
     * @param action the action to be performed within a transaction
     * @throws RuntimeException if an error occurs during the transaction execution
     */
    private void executeTransaction(TransactionAction action) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            action.execute(session);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Transaction failed", e);
        }
    }

    /**
     * Functional interface for actions that are executed within a transaction.
     * <p>
     * This interface defines a method for performing operations using a Hibernate {@link Session}.
     * </p>
     */
    @FunctionalInterface
    private interface TransactionAction {

        /**
         * Executes a database operation using the provided Hibernate {@link Session}.
         *
         * @param session the Hibernate session to be used for the transaction
         */
        void execute(Session session);
    }
}
