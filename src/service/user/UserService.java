package service.user;

import db.Database;
import db.UserDao;
import models.User;
import service.BaseService;

import java.util.List;
import java.util.Scanner;

public class UserService extends BaseService {

    public UserService(Database db, Scanner intScanner, Scanner strScanner) {
        super(db, intScanner, strScanner);
    }

    public void enterAsAmin() {
        System.out.println("---Select admin---");
        while (true) {
            UserDao userDao = db.getUserDao();
            AdminService adminService = new AdminService(db, intScanner, strScanner);
            List<User> admins = userDao.getAdmins();
            try {
                for (int i = 1; i <= admins.size(); i++) {
                    System.out.printf("%d. %s \n", i, admins.get(i - 1).getName());
                }
                System.out.printf("%d. %s \n", admins.size() + 1, "Add admin");
                System.out.println("0. Back");

                int cmd = intScanner.nextInt();

                if (cmd == 0) {
                    return;
                } else if (cmd <= admins.size() && cmd > 0) {
                    adminService.showMenu();
                } else if (cmd == admins.size() + 1) {
                    adminService.addAdmin();
                } else {
                    System.out.println("Invalid option!!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
    }

    public void enterAsCustomer() {
        System.out.println("---Select customer---");
        while (true) {
            CustomerService customerService = new CustomerService(db, intScanner, strScanner);
            UserDao userDao = db.getUserDao();
            List<User> customers = userDao.getCustomers();
            try {
                for (int i = 1; i <= customers.size(); i++) {
                    System.out.printf("%d. %s \n", i, customers.get(i - 1).getName());
                }
                System.out.printf("%d. %s \n", customers.size() + 1, "Add customer");
                System.out.println("0. Back");

                int cmd = intScanner.nextInt();

                if (cmd == 0) {
                    return;
                } else if (cmd <= customers.size() && cmd > 0) {
                    //TODO
                } else if (cmd == customers.size() + 1) {
                    customerService.addCustomer();
                } else {
                    System.out.println("Invalid option!!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
    }
}
