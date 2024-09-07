package org.spotify.operations;

import org.spotify.entities.Radio;

import java.util.Scanner;

public class AddRadio {
    private final Scanner scanner = new Scanner(System.in);

    public void add() {
        Radio radio = new Radio();
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
