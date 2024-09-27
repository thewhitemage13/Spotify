package org.spotify.operations;

import org.spotify.entities.Radio;
import org.spotify.services.RadioService;

import java.util.Scanner;

public class PrintRadio {
    private final Scanner scanner = new Scanner(System.in);
    private final RadioService radioService = new RadioService();

    public void print() {
        System.out.print("Enter radio Id: ");
        Long radioId = scanner.nextLong();
        Radio radio = radioService.findById(radioId);
        System.out.println(radio);
    }

}
