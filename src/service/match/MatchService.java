package service.match;

import db.*;

import models.Match;
import models.Team;
import models.Ticket;
import models.enums.MatchLevel;
import models.enums.MatchState;
import models.stadium.Seat;
import models.stadium.Sector;
import models.stadium.Stadium;
import service.BaseService;

import java.util.List;
import java.util.Scanner;

public class MatchService extends BaseService {

    public MatchService(Database db, Scanner intScanner, Scanner strScanner) {
        super(db, intScanner, strScanner);
    }

    public void showAdminUpcomingMatches() {
        MatchDao matchDao = db.getMatchDao();
        while (true) {
            List<Match> matches = matchDao.getUpcomingMatches();
            System.out.println("---Upcoming Matches---");
            if (matches.isEmpty()) {
                System.out.println("Matches not found!!!");

                System.out.println("0. Back");
                int cmd = intScanner.nextInt();
                if (cmd == 0) return;
                else {
                    System.out.println("Invalid option");
                }
            } else {
                try {
                    System.out.print("Select match to enter result: \n");
                    for (int i = 1; i <= matches.size(); i++) {
                        Match match = matches.get(i - 1);
                        System.out.printf("%d. %s - %s\n", i, match.getFirstTeam().getName(), match.getSecondTeam().getName());
                        System.out.printf("   Stadium: %s\n", match.getStadium().getName());
                        System.out.printf("   Time: %s\n", match.getDate());
                    }
                    System.out.println("0. Back");
                    int matchNumber = intScanner.nextInt();

                    if (matchNumber == 0) return;

                    if (matchNumber >= 1 && matchNumber <= matches.size()) {
                        matchDao.updateMatch(setMatchScore(matches.get(matchNumber - 1)));
                        System.out.println("Updated successfully!!!");
                    } else {
                        System.out.println("Invalid option!!!");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid option!!!");
                    intScanner.next();
                }
            }
        }
    }

    public void showCustomerUpcomingMatches() {
        MatchDao matchDao = db.getMatchDao();
        TicketDao ticketDao = db.getTicketDao();
        while (true) {
            List<Match> matches = matchDao.getUpcomingMatches();
            System.out.println("---Upcoming Matches---");
            if (matches.isEmpty()) {
                System.out.println("Matches not found!!!");

                System.out.println("0. Back");
                int cmd = intScanner.nextInt();
                if (cmd == 0) return;
                else {
                    System.out.println("Invalid option");
                }
            } else {
                try {
                    System.out.print("Select match to buy a ticket: \n");
                    for (int i = 1; i <= matches.size(); i++) {
                        Match match = matches.get(i - 1);
                        System.out.printf("%d. %s - %s\n", i, match.getFirstTeam().getName(), match.getSecondTeam().getName());
                        System.out.printf("   Stadium: %s\n", match.getStadium().getName());
                        System.out.printf("   Time: %s\n", match.getDate());
                    }
                    System.out.println("0. Back");
                    int matchNumber = intScanner.nextInt();

                    if (matchNumber == 0) return;

                    if (matchNumber >= 1 && matchNumber <= matches.size()) {
                        Ticket ticket = buyTicket(matches.get(matchNumber - 1));
                        if (ticket != null) {
                            matchDao.updateMatch(ticket.getMatch());
                            ticketDao.addTicket(ticket);
                            System.out.println("You will pay: " + ticket.getPrice());
                        } else {
                            System.out.println("Cancelled!!!");
                        }
                    } else {
                        System.out.println("Invalid option!!!");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid option!!!");
                    intScanner.next();
                }
            }
        }
    }

    public void showFinishedMatches() {
        MatchDao matchDao = db.getMatchDao();
        List<Match> matches = matchDao.getFinishedMatches();
        System.out.println("---Finished Matches---");
        if (matches.isEmpty()) {
            System.out.println("Matches not found!!!");
        } else {
            for (int i = 1; i <= matches.size(); i++) {
                Match match = matches.get(i - 1);
                System.out.println(match.stringWithScores());
            }
        }
        while (true) {
            try {
                System.out.println("0. Back");
                int cmd = intScanner.nextInt();
                if (cmd == 0) return;
                System.out.println("Invalid option!!!");
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
    }

    public void createMatch() {

        MatchDao matchDao = db.getMatchDao();

        Team team1, team2;
        Stadium stadium;
        String date;
        MatchLevel level = MatchLevel.LOW;

        team1 = selectTeam(1);
        team2 = selectTeam(2);
        stadium = selectStadium();

        while (true) {
            System.out.print("Enter match date(dd/mm/yyyy): ");
            date = strScanner.next();
            if (Util.validDate(date)) {
                break;
            } else {
                System.out.println("Invalid date!!!");
            }
        }

        while (true) {
            try {

                System.out.print("Enter the match degree(1 High, 2 Medium, 3 Low): ");
                int matchDegree = intScanner.nextInt();
                switch (matchDegree) {
                    case 1 -> level = MatchLevel.HIGH;
                    case 2 -> level = MatchLevel.MEDIUM;
                    case 3 -> level = MatchLevel.LOW;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }

        Match match = new Match(team1, team2, stadium, date, level);

        matchDao.createMatch(match);

    }

    private Team selectTeam(int whichTeam) {
        TeamDao teamDao = db.getTeamDao();
        while (true) {
            try {
                List<Team> teams = teamDao.getAll();
                System.out.printf("Select %d-team: \n\n", whichTeam);
                for (int i = 0; i < teams.size(); i++) {
                    System.out.print(i + 1 + " ");
                    System.out.println(teams.get(i).toString());
                }
                int teamNumber = intScanner.nextInt();

                if (teamNumber >= 1 && teamNumber <= teams.size()) {
                    return teams.get(teamNumber - 1);
                } else {
                    System.out.println("Invalid option!!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
    }

    private Stadium selectStadium() {
        StadiumDao stadiumDao = db.getStadiumDao();
        while (true) {
            try {
                List<Stadium> stadiums = stadiumDao.getAll();
                System.out.println("Select stadium");
                for (int i = 0; i < stadiums.size(); i++) {
                    System.out.print(i + 1 + " ");
                    System.out.println(stadiums.get(i).toString());
                }
                int teamNumber = intScanner.nextInt();

                if (teamNumber >= 1 && teamNumber <= stadiums.size()) {
                    return stadiums.get(teamNumber - 1);
                } else {
                    System.out.println("Invalid option!!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
    }

    private Match setMatchScore(Match match) {
        int firstTeamScore, secondTeamScore;
        while (true) {
            try {
                System.out.printf("Score of %s: ", match.getFirstTeam().getName());
                firstTeamScore = intScanner.nextInt();
                if (firstTeamScore >= 0) {
                    match.setFirstTeamScore(firstTeamScore);
                    break;
                } else {
                    System.out.println("Invalid option!!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
        while (true) {
            try {
                System.out.printf("Score of %s: ", match.getSecondTeam().getName());
                secondTeamScore = intScanner.nextInt();
                if (secondTeamScore >= 0) {
                    match.setSecondTeamScore(secondTeamScore);
                    break;
                } else {
                    System.out.println("Invalid option!!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
        match.setState(MatchState.FINISHED);
        return match;
    }

    private Ticket buyTicket(Match match) {
        List<Sector> sectors = match.getStadium().getSectors();

        Sector sector;
        Seat seat;
        while (true) {
            try {
                System.out.println("Select sector: ");
                for (int i = 0; i < sectors.size(); i++) {
                    System.out.println(i + 1 + " " + sectors.get(i).getName());
                }
                System.out.println("0. Cancel");
                int cmd = intScanner.nextInt();
                if (cmd == 0) return null;
                if (cmd >= 0 && cmd <= sectors.size()) {
                    sector = sectors.get(cmd - 1);
                    break;
                } else {
                    System.out.println("Invalid option!!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
        while (true) {
            List<Seat> seats = sector.getSeats();
            try {
                for (Seat value : seats) {
                    System.out.print(value.getNumber() + " ");
                }
                System.out.println("\n0. Cancel");
                int cmd = intScanner.nextInt();
                if (cmd == 0) return null;
                if (cmd >= 0 && cmd <= seats.size()) {
                    seat = seats.get(cmd - 1);
                    if (!seat.isBusy()) {
                        seat.setBusy(true);
                        break;
                    } else {
                        System.out.println("Seat is busy!!!");

                    }
                } else {
                    System.out.println("Invalid option!!!");
                }
            } catch (Exception e) {
                System.out.println("Invalid option!!!");
                intScanner.next();
            }
        }
        sector.updateSeat(seat);
        match.getStadium().updateSector(sector);
        return new Ticket(match, sector, seat);
    }
}
























