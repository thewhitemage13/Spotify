package org.spotify.operations;

import org.spotify.entities.Radio;
import org.spotify.services.interfaces.Service;

import java.util.List;
import java.util.Scanner;

/**
 * Provides operations for managing radio stations.
 * <p>
 * This class allows for adding, updating, deleting, and retrieving radio stations through interactions
 * with the {@link Service} interface. The radio stations include attributes such as city, country,
 * radio name, and URL.
 * </p>
 *
 * @author Mukhammed Lolo
 * @version 1.0
 */
public class RadioOperations implements Operation{

    /**
     * The service used for performing operations on {@link Radio} entities.
     * This service handles interactions with the repository to save, update, delete, and retrieve radio data.
     */
    private final Service<Radio> radioService;

    /**
     * A {@link Scanner} object used to gather input from the user.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a {@link RadioOperations} instance with the specified {@link Service} for managing radios.
     *
     * @param radioService the service used for performing operations on {@link Radio} entities.
     */
    public RadioOperations(Service<Radio> radioService) {
        this.radioService = radioService;
    }

    /**
     * Adds a new radio station.
     * <p>
     * This method collects the necessary details from the user, creates a new {@link Radio} object,
     * and saves it using the {@link Service#save(Object)} method.
     * </p>
     */
    @Override
    public void addOperation() {
        Radio radio = new Radio();
        createProcessor(radio);
        radioService.save(radio);
    }

    /**
     * Updates an existing radio station.
     * <p>
     * This method prompts the user to enter the radio station's ID, retrieves the existing radio
     * station, allows the user to modify its details, and updates it using the {@link Service#update(Object)} method.
     * </p>
     */
    @Override
    public void updateOperation() {
        System.out.print("Enter Radio Id: ");
        Long id = scanner.nextLong();
        Radio radio = radioService.findById(id);
        createProcessor(radio);
        radioService.update(radio);
    }

    /**
     * Deletes a radio station.
     * <p>
     * This method prompts the user to enter the radio station's ID and deletes the corresponding radio station
     * using the {@link Service#delete(Long)} (id)} method.
     * </p>
     */
    @Override
    public void deleteOperation() {
        System.out.print("Enter Radio Id: ");
        Long id = scanner.nextLong();
        radioService.delete(id);
    }

    /**
     * Retrieves and displays all radio stations.
     * <p>
     * This method fetches all radio stations using the {@link Service#findAll()} method and prints their details.
     * </p>
     */
    @Override
    public void findAllOperations() {
        List<Radio> radios = radioService.findAll();
        for (Radio radio : radios) {
            System.out.println(radio);
        }
    }

    /**
     * Retrieves and displays a radio station by its ID.
     * <p>
     * This method prompts the user for the radio station's ID, fetches the radio station using
     * the {@link Service#findById(Long)} method, and prints its details.
     * </p>
     */
    @Override
    public void findByIdOperation() {
        System.out.print("Enter Radio Id: ");
        Long id = scanner.nextLong();
        Radio radio = radioService.findById(id);
        System.out.println(radio);
    }

    /**
     * Collects the necessary details to create or update a {@link Radio} object.
     * <p>
     * This method prompts the user for details such as city, country, radio name, and URL,
     * and sets these values on the provided {@link Radio} object.
     * </p>
     *
     * @param radio the {@link Radio} object to be created or updated.
     */
    private void createProcessor(Radio radio) {
        System.out.println("Enter information about Radio: ");

        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        radio.setCity(city);

        System.out.print("Enter country: ");
        String country = scanner.nextLine();
        radio.setCountry(country);

        System.out.print("Radio name: ");
        String radioName = scanner.nextLine();
        radio.setRadioName(radioName);

        System.out.print("Radio Url: ");
        String radioUrl = scanner.nextLine();
        radio.setRadioUrl(radioUrl);
    }
}
