package org.spotify.operations;

import org.spotify.db.dao.MusicCollectionDAO;
import org.spotify.db.dao.RadioDAO;
import org.spotify.db.dao.Repository;
import org.spotify.db.dao.SongDAO;
import org.spotify.entities.MusicCollection;
import org.spotify.entities.Radio;
import org.spotify.entities.Song;
import org.spotify.players.ConsolePlayer;
import org.spotify.players.ConsoleRadio;
import org.spotify.services.MusicCollectionService;
import org.spotify.services.RadioService;
import org.spotify.services.SongService;
import org.spotify.services.interfaces.Service;

/**
 * Provides operations for playing radio stations, songs, and music collections.
 * <p>
 * This class interacts with various services and repositories to control the playback of radio stations,
 * individual songs, and entire music collections. It delegates the actual playback to the respective console player
 * classes, such as {@link ConsoleRadio} and {@link ConsolePlayer}.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class PlayerOperations {

    /**
     * The repository for managing {@link Radio} entities. This repository is used for interacting with radio data
     * stored in the database.
     */

    private final Repository<Radio> radioRepository = new RadioDAO();

    /**
     * The service for managing radio operations. This service interacts with the repository to perform CRUD operations
     * on radio stations and other related tasks.
     */
    private final RadioService radioService = new RadioService(radioRepository);

    /**
     * The console player used to play radio stations. This player interacts with the {@link RadioService} to retrieve
     * and play radio stations.
     */
    private final ConsoleRadio consoleRadio = new ConsoleRadio(radioService);

    /**
     * The repository for managing {@link Song} entities. This repository is used for interacting with song data
     * stored in the database.
     */
    private final Repository<Song> songRepository = new SongDAO();

    /**
     * The service for managing song operations. This service interacts with the repository to perform CRUD operations
     * on songs and other related tasks.
     */
    private final SongService songService = new SongService(songRepository);

    /**
     * The repository for managing {@link MusicCollection} entities. This repository is used for interacting with
     * music collection data stored in the database.
     */
    private final Repository<MusicCollection> musicCollectionRepository = new MusicCollectionDAO();

    /**
     * The service for managing music collection operations. This service interacts with the repository to perform CRUD
     * operations on music collections and other related tasks.
     */
    private final Service<MusicCollection> musicCollectionService = new MusicCollectionService(musicCollectionRepository);

    /**
     * The console player used to play music collections. This player interacts with the {@link MusicCollectionService}
     * to retrieve and play music collections.
     */
    private final ConsolePlayer consolePlayer = new ConsolePlayer(songService, musicCollectionService);

    /**
     * Plays a radio station through the {@link ConsoleRadio} player.
     * This method delegates to the {@link ConsoleRadio#playRadio()} method to initiate playback of the radio station.
     */
    public void playRadio() {
        consoleRadio.playRadio();
    }

    /**
     * Plays a music collection through the {@link ConsolePlayer}.
     * This method delegates to the {@link ConsolePlayer#playMusicCollection()} method to initiate playback of a music collection.
     */
    public void playMusicCollection() {
        consolePlayer.playMusicCollection();
    }

    /**
     * Plays a single song through the {@link ConsolePlayer}.
     * This method delegates to the {@link ConsolePlayer#playMusic()} method to initiate playback of a single song.
     */
    public void playSong() {
        consolePlayer.playMusic();
    }
}
