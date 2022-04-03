package db;

import models.stadium.Stadium;

import java.util.List;

public class StadiumDao {

    Database db;

    public StadiumDao(Database db) {
        this.db = db;
    }

    public List<Stadium> getAll() {
        return db.stadiums;
    }

}
