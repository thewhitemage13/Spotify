package org.spotify.operations;

import org.spotify.db.dao.RadioDao;

import java.util.Scanner;

public class DeleteRadio {
    private final RadioDao radioDao = new RadioDao();
    private final Scanner scanner = new Scanner(System.in);

    public void delete() {
        System.out.print("Enter radio Id: ");
        Long radioId = scanner.nextLong();
        radioDao.deleteRadioById(radioId);
        System.out.println("Radio deleted");
    }
}
