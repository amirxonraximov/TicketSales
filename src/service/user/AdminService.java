package service.user;

import db.Database;
import db.UserDao;
import db.Util;
import models.User;
import service.BaseService;
import service.match.MatchService;
import service.stadium.StadiumService;
import service.team.TeamService;

import java.util.List;
import java.util.Scanner;

public class AdminService extends BaseService {

    public AdminService(Database db, Scanner intScanner, Scanner strScanner) {
        super(db, intScanner, strScanner);
    }

    public void showMenu() {
        System.out.println("----Admin Menu----");
        while (true) {
            StadiumService stadiumService = new StadiumService(db, intScanner, strScanner);
            MatchService matchService = new MatchService(db, intScanner, strScanner);
            TeamService teamService = new TeamService(db, intScanner, strScanner);
            try {
                System.out.println("1. Add new match");
                System.out.println("2. Show upcoming matches");
                System.out.println("3. Show finished matches");
                System.out.println("4. Show standing");
                System.out.println("5. Show stadiums");
                System.out.println("0. Back");
                int cmd = strScanner.nextInt();

                switch (cmd) {
                    case 1 -> {

                    }
                    case 2 -> {
                        matchService.showUpcomingMatches();
                    }
                    case 3 -> {
                        matchService.showFinishedMatches();
                    }
                    case 4 -> {
                        teamService.showStanding();
                    }
                    case 5 -> {
                        stadiumService.showStadiums();
                    }
                    case 0 -> {
                        return;
                    }
                    default -> {
                        System.out.println("Invalid option!!!");
                    }
                }

            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
    }

    public void addAdmin() {
        UserDao userDao = db.getUserDao();
        System.out.println("---Enter admin details---");
        while (true) {
            try {
                String customerEmail;
                String customerName;
                while (true) {
                    System.out.println("Enter the admin name: ");
                    customerName = strScanner.nextLine();
                    if (!Util.validateName(customerName)) {
                        System.out.println("Name should be longer than 3 charters!!!");
                    } else {
                        break;
                    }
                }
                while (true) {
                    System.out.println("Enter the admin e-mail: ");
                    customerEmail = strScanner.nextLine();
                    if (!Util.validateEmail(customerEmail)) {
                        System.out.println("Invalid email!!!");
                    } else {
                        break;
                    }
                }
                userDao.addAdmin(customerName, customerEmail);
                System.out.println("Admin added successfully!!\n");
                return;
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
    }
}
