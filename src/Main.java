import db.Database;
import service.MainService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        Scanner intScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        MainService service = new MainService(db, intScanner, strScanner);
        service.run();
    }
}
 