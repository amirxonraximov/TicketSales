package service.ticket;

import db.Database;
import db.TicketDao;
import models.Ticket;
import models.stadium.Stadium;
import service.BaseService;

import java.util.List;
import java.util.Scanner;

public class TicketServices extends BaseService {

    public TicketServices(Database db, Scanner intScanner, Scanner strScanner) {
        super(db, intScanner, strScanner);
    }

    public void showPurchasedTickets() {
        TicketDao ticketDao = db.getTicketDao();
        List<Ticket> tickets = ticketDao.getAll();
        System.out.println("---Tickets---");
        for (int i = 1; i <= tickets.size(); i++) {
            System.out.println(tickets.get(i - 1).toString());
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
