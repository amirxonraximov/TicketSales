package service.user;

import db.Database;
import db.UserDao;
import db.Util;
import service.BaseService;
import service.match.MatchService;
import service.stadium.StadiumService;
import service.team.TeamService;

import java.util.Scanner;

public class CustomerService extends BaseService {

    public CustomerService(Database db, Scanner intScanner, Scanner strScanner) {
        super(db, intScanner, strScanner);
    }

    public void showMenu() {
        System.out.println("----Customer Menu----");
        while (true) {
            StadiumService stadiumService = new StadiumService(db, intScanner, strScanner);
            MatchService matchService = new MatchService(db, intScanner, strScanner);
            TeamService teamService = new TeamService(db, intScanner, strScanner);
            try {
                System.out.println("1. Show upcoming matches");
                System.out.println("2. Show finished matches");
                System.out.println("3. Show standing");
                System.out.println("3. Show Purchased tickets");
                System.out.println("0. Back");
                int cmd = strScanner.nextInt();

                switch (cmd) {
                    case 1 -> {
                        matchService.showCustomerUpcomingMatches();
                    }
                    case 2 -> {
                        matchService.showFinishedMatches();
                    }
                    case 3 -> {
                        teamService.showStanding();
                    }
                    case 4 -> {

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


    public void addCustomer() {
        UserDao userDao = db.getUserDao();
        System.out.println("---Enter user details---");
        while (true) {
            try {
                String customerEmail;
                String customerName;
                while (true) {
                    System.out.println("Enter the customer name: ");
                    customerName = strScanner.nextLine();
                    if (!Util.validateName(customerName)) {
                        System.out.println("Name should be longer than 3 charters!!!");
                    } else {
                        break;
                    }
                }
                while (true) {
                    System.out.println("Enter the customer e-mail: ");
                    customerEmail = strScanner.nextLine();
                    if (!Util.validateEmail(customerEmail)) {
                        System.out.println("Invalid email!!!");
                    } else {
                        break;
                    }
                }
                userDao.addCustomer(customerName, customerEmail);
                System.out.println("Customer added successfully!!\n");
                return;
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
    }
}
