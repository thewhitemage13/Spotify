package org.spotify.operations;

import org.spotify.db.dao.PerformerDao;

import java.util.Scanner;

public class DeletePerformer {
    Scanner scanner = new Scanner(System.in);
    PerformerDao performerDao = new PerformerDao();

    public void delete() {
        System.out.print("Enter performer name: ");
        String name = scanner.nextLine();
        performerDao.deletePerformerByName(name);
        System.out.println("Performer deleted");
    }
}
