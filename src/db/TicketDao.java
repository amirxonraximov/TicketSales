package db;

import models.Team;
import models.Ticket;
import models.User;
import models.enums.UserRole;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TicketDao {

    Database db;

    public TicketDao(Database db) {
        this.db = db;
    }

    public List<Ticket> getAll() {
        return db.tickets;
    }

    public void addTicket(Ticket ticket) {
        db.tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        db.tickets.remove(ticket);
    }

    public List<Ticket> getUserTickets(String userId) {
        List<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : db.tickets) {
            if (Objects.equals(ticket.getId(), userId)) {
                tickets.add(ticket);
            }
        }
        return tickets;
    }
}
