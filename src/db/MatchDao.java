package db;

import models.Match;
import models.Team;
import models.User;
import models.enums.MatchState;
import models.enums.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            if (match.getState() == MatchState.UPCOMING) {
                upcomingMatches.add(match);
            }
        }
        return upcomingMatches;
    }

    public void createMatch(Match match) {
        db.matches.add(match);
    }

    public void updateMatch(Match match) {
        int firstTeamScore = match.getFirstTeamScore();
        int secondTeamScore = match.getSecondTeamScore();
        Team firstTeam = match.getFirstTeam();
        Team secondTeam = match.getSecondTeam();
        TeamDao teamDao = db.getTeamDao();
        if (firstTeamScore == secondTeamScore) {
            firstTeam.setPoint(firstTeam.getPoint() + 1);
            secondTeam.setPoint(secondTeam.getPoint() + 1);
            teamDao.updateTeam(firstTeam);
            teamDao.updateTeam(secondTeam);
        } else if (firstTeamScore > secondTeamScore) {
            firstTeam.setPoint(firstTeam.getPoint() + 3);
            teamDao.updateTeam(firstTeam);
        } else {
            secondTeam.setPoint(secondTeam.getPoint() + 3);
            teamDao.updateTeam(secondTeam);
        }
        for (int i = 0; i < db.matches.size(); i++) {
            if (Objects.equals(db.matches.get(i).getId(), match.getId())) {
                db.matches.set(i, match);
            }
        }
    }
}
