package db;

import models.User;
import models.enums.UserRole;
import models.stadium.Stadium;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    Database db;

    public UserDao(Database db) {
        this.db = db;
    }

    public List<User> getAll() {
        return db.users;
    }

    public List<User> getAdmins() {
        List<User> admins = new ArrayList<>();
        for (User user : db.users) {
            if (user.getRole() == UserRole.ADMIN) {
                admins.add(user);
            }
        }
        return admins;
    }

    public List<User> getCustomers() {
        List<User> customers = new ArrayList<>();
        for (User user : db.users) {
            if (user.getRole() == UserRole.CUSTOMER) {
                customers.add(user);
            }
        }
        return customers;
    }

    public void addCustomer(String name, String email) {
        db.users.add(new User(name.toLowerCase().replace(" ", "_"), name, email, UserRole.CUSTOMER));
    }

    public void addAdmin(String name, String email) {
        db.users.add(new User(name.toLowerCase().replace(" ", "_"), name, email, UserRole.ADMIN));
    }
}
