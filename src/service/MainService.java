package service;

import db.Database;
import service.user.UserService;

import java.util.Scanner;

public class MainService extends BaseService {


    public MainService(Database db, Scanner intScanner, Scanner strScanner) {
        super(db, intScanner, strScanner);
    }

    public void run() {
        System.out.println("---Welcome to the TicketSales---");
        UserService userService = new UserService(db, intScanner, strScanner);
        while (true) {
            try {
                System.out.println("1. Login as Admin");
                System.out.println("2. Login as Customer");
                System.out.println("0. Exit");
                int cmd = intScanner.nextInt();
                switch (cmd) {
                    case 1 -> userService.enterAsAmin();
                    case 2 -> userService.enterAsCustomer();
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Invalid option!!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
    }
}
