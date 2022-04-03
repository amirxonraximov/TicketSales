package service;

import db.Database;

import java.util.Scanner;

public class BaseService {

    protected Database db;
    protected Scanner intScanner;
    protected Scanner strScanner;

    public BaseService(Database db, Scanner intScanner, Scanner strScanner) {
        this.db = db;
        this.intScanner = intScanner;
        this.strScanner = strScanner;
    }
}
