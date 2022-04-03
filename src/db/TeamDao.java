package db;

import models.Team;

import java.util.List;

public class TeamDao {

    Database db;

    public TeamDao(Database db) {
        this.db = db;
    }

    public List<Team> getAll() {
        return db.teams;
    }
}
