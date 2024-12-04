package org.spotify.services;

import org.spotify.db.dao.Repository;
import org.spotify.entities.MusicCollection;
import org.spotify.entities.Song;
import org.spotify.services.interfaces.Service;

import java.util.List;

/**
 * Service class for managing {@link Song} entities.
 * <p>
 * This class provides methods for saving, updating, deleting, and finding songs
 * by interacting with a {@link Repository} for {@link Song} entities.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class SongService implements Service<Song> {

    /**
     * The repository used to manage {@link MusicCollection} entities.
     * This repository is responsible for interacting with the data source to perform CRUD operations.
     */
    private final Repository<Song> repository;

    /**
     * Constructs a {@link SongService} with the specified repository for song entities.
     *
     * @param repository the repository to manage {@link Song} entities
     */
    public SongService(Repository<Song> repository) {
        this.repository = repository;
    }

    /**
     * Saves a new song to the repository.
     *
     * @param song the {@link Song} to save
     */
    @Override
    public void save(Song song) {
        repository.save(song);
    }

    /**
     * Updates an existing song in the repository.
     *
     * @param song the {@link Song} to update
     */
    @Override
    public void update(Song song) {
        repository.update(song);
    }

    /**
     * Deletes a song from the repository by its ID.
     * <p>
     * If no {@link Song} with the specified ID is found, no action is taken.
     * </p>
     *
     * @param id the ID of the song to delete
     */
    @Override
    public void delete(Long id) {
        Song song = findById(id);
        if (song == null) return;
        repository.delete(song);
    }


    /**
     * Retrieves all songs from the repository.
     *
     * @return a list of all {@link Song} entities
     */
    @Override
    public List<Song> findAll() {
        return repository.findAll();
    }

    /**
     * Finds a song by its ID.
     *
     * @param id the ID of the song to find
     * @return the {@link Song} with the specified ID, or null if not found
     */
    @Override
    public Song findById(Long id) {
        return repository.findById(id);
    }
}
