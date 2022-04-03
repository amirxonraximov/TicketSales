package service.stadium;

import db.Database;
import db.StadiumDao;
import models.stadium.Stadium;
import service.BaseService;

import java.util.List;
import java.util.Scanner;

public class StadiumService extends BaseService {

    public StadiumService(Database db, Scanner intScanner, Scanner strScanner) {
        super(db, intScanner, strScanner);
    }

    public void showStadiums() {
        StadiumDao stadiumDao = db.getStadiumDao();
        List<Stadium> stadiums = stadiumDao.getAll();
        System.out.println("---Stadiums---");
        for (int i = 1; i <= stadiums.size(); i++) {
            System.out.printf("%d. %s\n", i, stadiums.get(i - 1).getName());
            System.out.printf("   Address: %s\n", stadiums.get(i - 1).getAddress());
            System.out.println();
        }
        while (true) {
            try {
                System.out.println("0. Back");
                int cmd = intScanner.nextInt();
                if (cmd == 0) return;
                System.out.println("Invalid option!!!");
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
    }
}
