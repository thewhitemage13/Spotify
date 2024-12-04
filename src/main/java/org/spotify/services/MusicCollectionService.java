package org.spotify.services;

import org.spotify.db.dao.Repository;
import org.spotify.entities.MusicCollection;
import org.spotify.services.interfaces.Service;

import java.util.List;

/**
 * Service class for managing {@link MusicCollection} entities.
 * <p>
 * This class provides methods for performing CRUD (Create, Read, Update, Delete) operations on music collections.
 * It interacts with the {@link Repository} for {@link MusicCollection} entities to persist and retrieve data.
 * </p>
 * <p>
 * The service is designed to abstract the database or storage layer, allowing easy management of music collections.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class MusicCollectionService implements Service<MusicCollection> {

    /**
     * The repository used to manage {@link MusicCollection} entities.
     * This is the main field that interacts with the data source (e.g., database)
     * for performing CRUD operations on performer data.
     */
    private final Repository<MusicCollection> repository;

    /**
     * Constructs a {@link MusicCollectionService} with the specified repository for music collections.
     * <p>
     * The repository is used to perform database operations such as saving, updating, deleting, and finding
     * music collections.
     * </p>
     *
     * @param repository the repository to manage {@link MusicCollection} entities
     */
    public MusicCollectionService(Repository<MusicCollection> repository) {
        this.repository = repository;
    }

    /**
     * Saves a new music collection to the repository.
     * <p>
     * This method persists the given {@link MusicCollection} entity to the database.
     * </p>
     *
     * @param collection the {@link MusicCollection} to save
     */
    @Override
    public void save(MusicCollection collection) {
        repository.save(collection);
    }

    /**
     * Updates an existing music collection in the repository.
     * <p>
     * This method updates the details of an existing {@link MusicCollection} in the database.
     * </p>
     *
     * @param collection the {@link MusicCollection} to update
     */
    @Override
    public void update(MusicCollection collection) {
        repository.update(collection);
    }

    /**
     * Deletes a music collection from the repository by its ID.
     * <p>
     * If no {@link MusicCollection} with the specified ID is found in the repository, no action is taken.
     * </p>
     *
     * @param id the ID of the music collection to delete
     */
    @Override
    public void delete(Long id) {
        MusicCollection musicCollection = findById(id);
        if (musicCollection == null) return;
        repository.delete(musicCollection);
    }

    /**
     * Retrieves all music collections from the repository.
     * <p>
     * This method returns a list of all {@link MusicCollection} entities stored in the repository.
     * </p>
     *
     * @return a list of all {@link MusicCollection} entities
     */
    @Override
    public List<MusicCollection> findAll() {
        return repository.findAll();
    }

    /**
     * Finds a music collection by its ID.
     * <p>
     * This method searches for a {@link MusicCollection} in the repository by its unique ID.
     * If the collection is found, it is returned; otherwise, it returns null.
     * </p>
     *
     * @param id the ID of the music collection to find
     * @return the {@link MusicCollection} with the specified ID, or null if not found
     */
    @Override
    public MusicCollection findById(Long id) {
        return repository.findById(id);
    }
}
