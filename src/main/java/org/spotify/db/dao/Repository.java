package org.spotify.db.dao;

import org.spotify.entities.MusicCollection;
import org.spotify.entities.Performer;
import org.spotify.entities.Song;

import java.util.List;

/**
 * Generic repository interface for CRUD (Create, Read, Update, Delete) operations.
 * <p>
 * This interface defines the basic operations that can be performed on entities of type {@code T}.
 * It is intended to be implemented by DAO (Data Access Object) classes to interact with the database.
 * By providing these common CRUD methods, it abstracts the data access logic for various entity types,
 * such as {@link MusicCollection}, {@link Performer}, and {@link Song}.
 * </p>
 *
 * @param <T> the type of the entity that this repository manages (e.g., {@link MusicCollection}, {@link Performer}, {@link Song})
 *
 * @see org.spotify.db.dao.MusicCollectionDAO
 * @see org.spotify.db.dao.PerformerDAO
 * @see org.spotify.db.dao.SongDAO
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public interface Repository<T> {

    /**
     * Saves a new entity to the database.
     * <p>
     * This method persists the given object into the database. The object will be inserted
     * as a new record.
     * </p>
     *
     * @param obj the entity to be saved
     */
    void save(T obj);

    /**
     * Updates an existing entity in the database.
     * <p>
     * This method modifies an existing record in the database with the provided object's
     * updated information.
     * </p>
     *
     * @param obj the entity to be updated
     */
    void update(T obj);

    /**
     * Deletes an entity from the database.
     * <p>
     * This method removes the provided object from the database.
     * </p>
     *
     * @param obj the entity to be deleted
     */
    void delete(T obj);

    /**
     * Retrieves all entities of the given type from the database.
     * <p>
     * This method fetches all records of type {@code T} from the database and returns them as a list.
     * </p>
     *
     * @return a list of all entities of type {@code T}
     */
    List<T> findAll();

    /**
     * Finds an entity by its ID.
     * <p>
     * This method retrieves a record of type {@code T} from the database based on the provided
     * ID and returns it. If no record is found, it returns {@code null}.
     * </p>
     *
     * @param id the ID of the entity to be found
     * @return the entity with the specified ID, or {@code null} if not found
     */
    T findById(Long id);
}
