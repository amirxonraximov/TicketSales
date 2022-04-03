package service.match;

import db.Database;
import db.MatchDao;

import models.Match;
import service.BaseService;

import java.util.List;
import java.util.Scanner;

public class MatchService extends BaseService {

    public MatchService(Database db, Scanner intScanner, Scanner strScanner) {
        super(db, intScanner, strScanner);
    }

    public void showUpcomingMatches() {
        MatchDao matchDao = db.getMatchDao();
        List<Match> matches = matchDao.getAll();
        System.out.println("---Stadiums---");
        if (matches.isEmpty()) {
            System.out.println("Matches not found!!!");
        } else {
            for (int i = 1; i <= matches.size(); i++) {
                Match match = matches.get(i - 1);
                System.out.printf("%d. %s - %s\n", i, match.getFirstTeam().getName(), match.getSecondTeam().getName());
                System.out.printf("   Stadium: %s\n", match.getStadium().getName());
                System.out.printf("   Time: %s\n", match.getDate());
                System.out.println();
            }
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
