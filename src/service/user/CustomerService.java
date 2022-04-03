package service.user;

import db.Database;
import db.UserDao;
import db.Util;
import service.BaseService;

import java.util.Scanner;

public class CustomerService extends BaseService {

    public CustomerService(Database db, Scanner intScanner, Scanner strScanner) {
        super(db, intScanner, strScanner);
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
