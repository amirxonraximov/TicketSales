package db;

import models.Match;
import models.Team;
import models.User;
import models.enums.UserRole;
import models.stadium.Stadium;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final Database instance = new Database();

    private Database() {
    }

    List<Stadium> stadiums = new ArrayList<>() {
        {
            add(new Stadium(
                    "camp_nou",
                    "Camp Nou",
                    "Spain, Barcelona"
            ));
            add(new Stadium(
                    "stamford_bridge",
                    "Stamford Bridge",
                    "England, London"
            ));
            add(new Stadium(
                    "alliance_arena",
                    "Alliance Arena",
                    "Germany, Munich"
            ));
            add(new Stadium(
                    "san_siro",
                    "San Siro",
                    "Italy, Milan"
            ));
        }
    };

    List<Team> teams = new ArrayList<>() {{
        add(new Team("barcelona", "Barcelona", 0));
        add(new Team("chelsea", "Chelsea", 0));
        add(new Team("bayern", "Bayern", 0));
        add(new Team("milan", "Milan", 0));
    }};

    List<User> users = new ArrayList<>() {{
        add(new User("admin", "Admin", "admin@gmail.com", UserRole.ADMIN));
        add(new User("costumer_1", "Costumer 1", "costumer@gmail.com", UserRole.CUSTOMER));
        add(new User("costumer_2", "Costumer 2", "costumer2@gmail.com", UserRole.CUSTOMER));
    }};

    List<Match> matches = new ArrayList<>();

    public StadiumDao getStadiumDao() {
        return new StadiumDao(instance);
    }

    public UserDao getUserDao() {
        return new UserDao(instance);
    }

    public MatchDao getMatchDao() {
        return new MatchDao(instance);
    }

    public static Database getInstance() {
        return instance;
    }

}
