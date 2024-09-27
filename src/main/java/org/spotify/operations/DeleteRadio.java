package org.spotify.operations;

import org.spotify.db.dao.RadioDao;
import org.spotify.services.RadioService;

import java.util.Scanner;

public class DeleteRadio {
    private final RadioService radioService = new RadioService();
    private final Scanner scanner = new Scanner(System.in);

    public void delete() {
        System.out.print("Enter radio Id: ");
        Long radioId = scanner.nextLong();
        radioService.deleteById(radioId);
        System.out.println("Radio deleted");
    }
}
