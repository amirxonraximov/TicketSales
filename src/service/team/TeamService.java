package service.team;

import db.Database;
import db.TeamDao;
import models.Team;
import service.BaseService;

import java.util.List;
import java.util.Scanner;

public class TeamService extends BaseService {


    public TeamService(Database db, Scanner intScanner, Scanner strScanner) {
        super(db, intScanner, strScanner);
    }

    public void showStanding() {
        TeamDao teamDao = db.getTeamDao();
        List<Team> teams = teamDao.getStandings();
        System.out.println("---Standing---");
        for (int i = 1; i <= teams.size(); i++) {
            System.out.printf("%d. %s - %d\n", i, teams.get(i - 1).getName(), teams.get(i - 1).getPoint());
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
