package models;

import models.enums.MatchLevel;
import models.enums.MatchState;
import models.stadium.Sector;
import models.stadium.Stadium;


public class Match {
    String id;
    Team firstTeam;
    Team secondTeam;
    Stadium stadium;
    String date;
    MatchLevel level;
    MatchState state = MatchState.UPCOMING;
    int firstTeamScore = -1;
    int secondTeamScore = -1;

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

    public Match(Team firstTeam, Team secondTeam, Stadium stadium, String date, MatchLevel level) {
        this.id = firstTeam.name + secondTeam.name + date;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.stadium = stadium;
        this.date = date;
        this.level = level;
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

    @Override
    public String toString() {
        return String.format("%s - %s\n", this.getFirstTeam().getName(), this.getSecondTeam().getName()) +
                String.format("   Stadium: %s\n", this.getStadium().getName()) +
                String.format("   Time: %s\n", this.getDate()) +
                String.format("   Match level: %s\n", this.getLevel().toString());
    }

    public String stringWithScores() {
        return String.format("%s %d - %d %s\n", this.getFirstTeam().getName(), this.getFirstTeamScore(), this.getSecondTeamScore(), this.getSecondTeam().getName()) +
                String.format("   Stadium: %s\n", this.getStadium().getName()) +
                String.format("   Time: %s\n", this.getDate());
    }
}
