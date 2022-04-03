package db;

import models.Match;
import models.User;
import models.enums.MatchState;
import models.enums.UserRole;

import java.util.ArrayList;
import java.util.List;

public class MatchDao {
    Database db;

    public MatchDao(Database db) {
        this.db = db;
    }

    public List<Match> getAll() {
        return db.matches;
    }

    public List<Match> getFinishedMatches() {
        List<Match> finishedMatches = new ArrayList<>();
        for (Match match : db.matches) {
            if (match.getState() == MatchState.FINISHED) {
                finishedMatches.add(match);
            }
        }
        return finishedMatches;
    }

    public List<Match> getUpcomingMatches() {
        List<Match> upcomingMatches = new ArrayList<>();
        for (Match match : db.matches) {
            if (match.getState() == MatchState.FINISHED) {
                upcomingMatches.add(match);
            }
        }
        return upcomingMatches;
    }

}
