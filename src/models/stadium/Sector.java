package models.stadium;

import models.enums.SectorLevel;

import java.util.List;

public class Sector {
    String id;
    String name;
    SectorLevel level;
    List<Seat> seats;

    public Sector(String id, String name, SectorLevel level, List<Seat> seats) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SectorLevel getLevel() {
        return level;
    }

    public void setLevel(SectorLevel level) {
        this.level = level;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
