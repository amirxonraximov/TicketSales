package db;

import models.Team;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TeamDao {

    Database db;

    public TeamDao(Database db) {
        this.db = db;
    }

    public List<Team> getAll() {
        return db.teams;
    }

    public List<Team> getStandings() {
        return db.teams.stream()
                .sorted(Comparator.comparing(Team::getPoint).reversed())
                .collect(Collectors.toList());
    }

    public void updateTeam(Team team) {
        for (int i = 0; i < db.teams.size(); i++) {
            if (Objects.equals(db.teams.get(i).getId(), team.getId())) {
                db.teams.set(i, team);
            }
        }
    }
}
