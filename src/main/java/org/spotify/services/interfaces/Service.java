package org.spotify.services.interfaces;

import java.util.List;

/**
 * A generic interface for performing CRUD (Create, Read, Update, Delete) operations.
 * <p>
 * This interface defines methods for managing entities of type {@code T}.
 * Implementing classes should provide specific behavior for these operations.
 * </p>
 *
 * @param <T> the type of the entity this service will manage
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public interface Service<T> {

    /**
     * Saves a new entity to the data store.
     *
     * @param obj the entity to save
     */
    void save(T obj);

    /**
     * Updates an existing entity in the data store.
     *
     * @param obj the entity with updated information
     */
    void update(T obj);

    /**
     * Deletes an entity from the data store by its identifier.
     *
     * @param id the unique identifier of the entity to delete
     */
    void delete(Long id);
    /**
     * Retrieves all entities from the data store.
     *
     * @return a list of all entities
     */
    List<T> findAll();

    /**
     * Finds an entity in the data store by its identifier.
     *
     * @param id the unique identifier of the entity
     * @return the entity with the given identifier, or {@code null} if not found
     */
    T findById(Long id);
}
