package org.spotify.operations;

import org.spotify.db.dao.MusicCollectionDao;
import org.spotify.entities.MusicCollection;
import org.spotify.entities.Performer;
import org.spotify.entities.Song;
import org.spotify.enums.TypeOfMusicCollection;
import org.spotify.services.PerformerService;
import org.spotify.validate.PerformerValidate;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

public class AddMusicCollection {
    private final MusicCollectionDao musicCollectionDao = new MusicCollectionDao();
    private final PerformerService performerService = new PerformerService();
    private final PerformerValidate performerValidate = new PerformerValidate();

    public MusicCollection add() {
        MusicCollection musicCollection = new MusicCollection();
        TypeOfMusicCollection[] types = TypeOfMusicCollection.values();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the performer name: ");
        String performerName = scanner.nextLine();
        performerValidate.validatePerformer(performerName);
        Performer performer = performerService.findPerformerByName(performerName);

        System.out.print("Please enter the name of the album: ");
        String name = scanner.nextLine();
        musicCollection.setName(name);

        System.out.print("All type of Music Collection: ");
        System.out.print(Arrays.toString(types) + "\n");

        System.out.print("Enter the type of the music collection: ");
        TypeOfMusicCollection typeOfCollection = TypeOfMusicCollection.valueOf(scanner.nextLine());
        musicCollection.setTypeOfCollection(typeOfCollection);

        LocalDate releaseDate = null;
        while (releaseDate == null) {
            System.out.print("Please enter the release date (yyyy-MM-dd): ");
            String dateInput = scanner.nextLine();
            try {
                releaseDate = LocalDate.parse(dateInput);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            }
        }

        musicCollection.setReleaseDate(releaseDate);

        musicCollection.setPerformer(performer);

        addSongsToAlbum(musicCollection);

        musicCollectionDao.saveMusicCollection(musicCollection);
        return musicCollection;
    }

    private void addSongsToAlbum(MusicCollection musicCollection) {
        Scanner scanner = new Scanner(System.in);
        String addMore;
        do {
            System.out.println("Add a new song to the album:");
            Song song = new Song();

            AddSong songInput = new AddSong();
            songInput.add(song);

            musicCollection.add(song);

            System.out.print("Do you want to add another song? (yes/no): ");
            addMore = scanner.nextLine().trim().toLowerCase();
        } while (addMore.equals("yes"));
    }
}
