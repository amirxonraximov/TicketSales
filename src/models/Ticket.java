package models;

import models.stadium.Seat;
import models.stadium.Sector;
import models.stadium.Stadium;

public class Ticket {
    String id;
    String userId;
    Match match;
    Sector sector;
    Seat seat;
    double price = 0;

    public Ticket(String id, String userId, Match match, Sector sector, Seat seat, double price) {
        this.id = id;
        this.userId = userId;
        this.match = match;
        this.sector = sector;
        this.seat = seat;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Ticket(Match match, Sector sector, Seat seat) {
        this.id = match.getId() + sector.getId() + seat.getId();
        this.match = match;
        this.sector = sector;
        this.seat = seat;

        switch (sector.getLevel()) {
            case VIP -> {
                price += 15;
            }
            case PREMIUM -> {
                price += 10;
            }
            case STANDARD -> {
                price += 5;
            }
        }
        switch (match.getLevel()) {
            case HIGH -> {
                price += 15;
            }
            case MEDIUM -> {
                price += 10;
            }
            case LOW -> {
                price += 5;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s\n", this.getMatch().getFirstTeam().getName(), this.getMatch().getSecondTeam().getName()) +
                String.format("   Stadium: %s\n", this.getMatch().getStadium().getName()) +
                String.format("   Sector: %s\n", this.getSector()) +
                String.format("   Seat: %s\n", this.getSeat()) +
                String.format("   Time: %s\n", this.getMatch().getDate());
    }

}
