package org.spotify.operations;

import org.spotify.entities.MusicCollection;
import org.spotify.entities.Song;

/**
 * Interface for operations that can be performed on entities in the system.
 * <p>
 * This interface defines basic CRUD operations: add, update, delete, findAll, and findById.
 * It is designed to be implemented by classes handling specific entities, such as {@link Song}, {@link MusicCollection}, etc.
 * </p>
 *
 * The operations allow users to create, modify, remove, and query entities in the system. These entities can represent various objects like songs, collections, and more.
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public interface Operation {

    /**
     * Adds a new entity to the system.
     * <p>
     * This method prompts for user input to collect necessary data and then saves the new entity.
     * </p>
     */
    void addOperation();

    /**
     * Updates an existing entity in the system.
     * <p>
     * This method prompts the user for the entity's ID, retrieves the entity, allows modifications, and saves the updated entity.
     * </p>
     */
    void updateOperation();

    /**
     * Deletes an existing entity from the system.
     * <p>
     * This method prompts the user for the entity's ID and deletes the corresponding entity from the system.
     * </p>
     */
    void deleteOperation();

    /**
     * Finds and displays all entities in the system.
     * <p>
     * This method retrieves all entities and displays their details.
     * </p>
     */
    void findAllOperations();

    /**
     * Finds and displays an entity by its ID.
     * <p>
     * This method prompts the user for the entity's ID, fetches the corresponding entity, and displays its details.
     * </p>
     */
    void findByIdOperation();
}
