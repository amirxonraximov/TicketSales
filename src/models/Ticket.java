package models;

import models.stadium.Seat;
import models.stadium.Sector;
import models.stadium.Stadium;

public class Ticket {
    String id;
    Match match;
    Stadium stadium;
    Sector sector;
    Seat seat;
    double price = 0;

    public Ticket(String id, Match match, Stadium stadium, Sector sector, Seat seat, double price) {
        this.id = id;
        this.match = match;
        this.stadium = stadium;
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

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
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

    public Ticket(String id, Match match, Stadium stadium, Sector sector, Seat seat) {
        this.id = id;
        this.match = match;
        this.stadium = stadium;
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
}
