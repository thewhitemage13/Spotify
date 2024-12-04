package org.spotify.services;

import org.spotify.db.dao.Repository;
import org.spotify.entities.Radio;
import org.spotify.services.interfaces.Service;

import java.util.List;

/**
 * Service class for managing {@link Radio} entities.
 * <p>
 * This class provides methods for saving, updating, deleting, and finding radios
 * by interacting with a {@link Repository} for {@link Radio} entities.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class RadioService implements Service<Radio> {
    /**
     * The repository used to manage {@link Radio} entities.
     * This repository is responsible for interacting with the data source to perform CRUD operations.
     */
    private final Repository<Radio> repository;

    /**
     * Constructs a {@link RadioService} with the specified repository for radio entities.
     *
     * @param repository the repository to manage {@link Radio} entities
     */
    public RadioService(Repository<Radio> repository) {
        this.repository = repository;
    }

    /**
     * Saves a new radio to the repository.
     *
     * @param radio the {@link Radio} to save
     */
    @Override
    public void save(Radio radio) {
        repository.save(radio);
    }

    /**
     * Updates an existing radio in the repository.
     *
     * @param radio the {@link Radio} to update
     */
    @Override
    public void update(Radio radio) {
        repository.update(radio);
    }

    /**
     * Deletes a radio from the repository by its ID.
     * <p>
     * If no {@link Radio} with the specified ID is found, no action is taken.
     * </p>
     *
     * @param id the ID of the radio to delete
     */
    @Override
    public void delete(Long id) {
        Radio radio = findById(id);
        if (radio == null) return;
        repository.delete(radio);
    }

    /**
     * Retrieves all radios from the repository.
     *
     * @return a list of all {@link Radio} entities
     */
    @Override
    public List<Radio> findAll() {
        return repository.findAll();
    }

    /**
     * Finds a radio by its ID.
     *
     * @param id the ID of the radio to find
     * @return the {@link Radio} with the specified ID, or null if not found
     */
    @Override
    public Radio findById(Long id) {
        return repository.findById(id);
    }
}
