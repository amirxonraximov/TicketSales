package models;

import models.enums.MatchLevel;
import models.enums.MatchState;
import models.stadium.Stadium;

public class Match {
    String id;
    Team firstTeam;
    Team secondTeam;
    Stadium stadium;
    String date;
    MatchLevel level;

    public Match(String id, Team firstTeam, Team secondTeam, Stadium stadium, String date, MatchLevel level,
                 MatchState state, int firstTeamScore, int secondTeamScore) {
        this.id = id;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.stadium = stadium;
        this.date = date;
        this.level = level;
        this.state = state;
        this.firstTeamScore = firstTeamScore;
        this.secondTeamScore = secondTeamScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MatchLevel getLevel() {
        return level;
    }

    public void setLevel(MatchLevel level) {
        this.level = level;
    }

    public MatchState getState() {
        return state;
    }

    public void setState(MatchState state) {
        this.state = state;
    }

    public int getFirstTeamScore() {
        return firstTeamScore;
    }

    public void setFirstTeamScore(int firstTeamScore) {
        this.firstTeamScore = firstTeamScore;
    }

    public int getSecondTeamScore() {
        return secondTeamScore;
    }

    public void setSecondTeamScore(int secondTeamScore) {
        this.secondTeamScore = secondTeamScore;
    }

    MatchState state = MatchState.UPCOMING;
    int firstTeamScore = -1;
    int secondTeamScore = -1;
}
