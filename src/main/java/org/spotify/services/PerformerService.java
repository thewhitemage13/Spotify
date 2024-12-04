package org.spotify.services;

import org.spotify.db.dao.Repository;
import org.spotify.entities.Performer;
import org.spotify.services.interfaces.Service;

import java.util.List;

/**
 * Service class for managing {@link Performer} entities.
 * <p>
 * This class provides methods for performing CRUD (Create, Read, Update, Delete) operations on performer entities.
 * It interacts with a {@link Repository} for {@link Performer} entities to persist and retrieve data.
 * </p>
 * <p>
 * The service acts as a layer between the database and the application, facilitating easy management of performer data.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class PerformerService implements Service<Performer> {

    /**
     * The repository used to manage {@link Performer} entities.
     * This is the main field that interacts with the data source (e.g., database)
     * for performing CRUD operations on performer data.
     */
    private final Repository<Performer> repository;

    /**
     * Constructs a {@link PerformerService} with the specified repository for performers.
     * <p>
     * The repository is used to perform database operations such as saving, updating, deleting, and finding
     * performer records.
     * </p>
     *
     * @param repository the repository to manage {@link Performer} entities
     */
    public PerformerService(Repository<Performer> repository) {
        this.repository = repository;
    }

    /**
     * Saves a new performer to the repository.
     * <p>
     * This method persists the given {@link Performer} entity to the database.
     * </p>
     *
     * @param performer the {@link Performer} to save
     */
    @Override
    public void save(Performer performer) {
        repository.save(performer);
    }

    /**
     * Updates an existing performer in the repository.
     * <p>
     * This method updates the details of an existing {@link Performer} in the database.
     * </p>
     *
     * @param performer the {@link Performer} to update
     */
    @Override
    public void update(Performer performer) {
        repository.update(performer);
    }

    /**
     * Deletes a performer from the repository by its ID.
     * <p>
     * If no {@link Performer} with the specified ID is found, no action is taken.
     * </p>
     *
     * @param id the ID of the performer to delete
     */
    @Override
    public void delete(Long id) {
        Performer performer = findById(id);
        if (performer == null) return;
        repository.delete(performer);
    }

    /**
     * Retrieves all performers from the repository.
     *
     * @return a list of all {@link Performer} entities
     */
    @Override
    public List<Performer> findAll() {
        return repository.findAll();
    }

    /**
     * Finds a performer by its ID.
     *
     * @param id the ID of the performer to find
     * @return the {@link Performer} with the specified ID, or null if not found
     */
    @Override
    public Performer findById(Long id) {
        return repository.findById(id);
    }
}
