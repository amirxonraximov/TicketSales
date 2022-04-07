package models.stadium;

import models.enums.SectorLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stadium {
    String id;
    String name;
    String address;
    List<Sector> sectors;

    public Stadium(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.sectors = populateSectors();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }

    private ArrayList<Sector> populateSectors() {
        return new ArrayList<>() {{
            add(new Sector("sector_a", "A", SectorLevel.VIP, new ArrayList<>() {{
                add(new Seat("seat_1", 1));
                add(new Seat("seat_2", 2));
                add(new Seat("seat_3", 3));
                add(new Seat("seat_4", 4));
                add(new Seat("seat_5", 5));
            }}));
            add(new Sector("sector_b", "B", SectorLevel.PREMIUM, new ArrayList<>() {{
                add(new Seat("seat_1", 1));
                add(new Seat("seat_2", 2));
                add(new Seat("seat_3", 3));
                add(new Seat("seat_4", 4));
                add(new Seat("seat_5", 5));
            }}));
            add(new Sector("sector_c", "C", SectorLevel.STANDARD, new ArrayList<>() {{
                add(new Seat("seat_1", 1));
                add(new Seat("seat_2", 2));
                add(new Seat("seat_3", 3));
                add(new Seat("seat_4", 4));
                add(new Seat("seat_5", 5));
            }}));
            add(new Sector("sector_d", "D", SectorLevel.STANDARD, new ArrayList<>() {{
                add(new Seat("seat_1", 1));
                add(new Seat("seat_2", 2));
                add(new Seat("seat_3", 3));
                add(new Seat("seat_4", 4));
                add(new Seat("seat_5", 5));
            }}));
        }};
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "  Address: " + address;
    }

    public void updateSector(Sector sector) {
        for (int i = 0; i < sectors.size(); i++) {
            if (Objects.equals(sectors.get(i).getId(), sector.getId())) {
                sectors.set(i, sector);
            }
        }
    }
}
