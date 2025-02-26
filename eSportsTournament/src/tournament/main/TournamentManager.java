package tournament.main;

import tournament.data.*;
import java.util.*;

public class TournamentManager{

    private final Player[] players;
    private final Team[] teams;
    private final Tournament[] tournaments;
    private final Match[] matches;

    public TournamentManager() {
        players = new Player[10];
        teams = new Team[5];
        tournaments = new Tournament[3];
        matches = new Match[5];

    }

    public void initialize() {
        players[0] = new Player("xlvxrx20", 55, 1404.9f);
        players[1] = new Player("Dyron2704", 100, 2340f);
        players[2] = new Player("Xx_Nico_xX", 75, 1800.3f);
        players[3] = new Player("GabrielPro", 90, 1309f);
        players[4] = new Player("Mxrcos69", 65, 1500f);
        players[5] = new Player("FrenchFries", 80, 2000.8f);
        players[6] = new Player("HokeLover", 95, 2600.2f);
        players[7] = new Player("CsharpHater", 70, 1700.6f);
        players[8] = new Player("DonLuisPanis", 88, 2250.4f);
        players[9] = new Player("Carlitos3245", 60, 1400f);

        teams[0] = new Team("TheBorratxos", 5);
        teams[0].addPlayer(players[0]);
        teams[0].addPlayer(players[1]);

        teams[1] = new Team("Titans", 5);
        teams[1].addPlayer(players[2]);
        teams[1].addPlayer(players[3]);

        teams[2] = new Team("Warriors", 5);
        teams[2].addPlayer(players[4]);
        teams[2].addPlayer(players[5]);

        teams[3] = new Team("Dragons", 5);
        teams[3].addPlayer(players[6]);
        teams[3].addPlayer(players[7]);

        teams[4] = new Team("Legends", 5);
        teams[4].addPlayer(players[8]);
        teams[4].addPlayer(players[9]);

        tournaments[0] = new IndividualTournament("Masters Solo", "CS:GO", 5000);
        tournaments[1] = new TeamTournament("Champions League", "Valorant", 7000, 5);
        tournaments[2] = new MixedTournament("Ultimate Battle", "League of Legends", 6000, "5v5");

        Random random = new Random();
        for (int i = 0; i < matches.length; i++) {
            Tournament selectedTournament = tournaments[random.nextInt(tournaments.length)];
            if (selectedTournament instanceof IndividualTournament) {
                Player p1 = players[random.nextInt(players.length)];
                Player p2;
                do {
                    p2 = players[random.nextInt(players.length)];
                } while (p1 == p2);
                matches[i] = new Match(selectedTournament, p1, p2);
            } else {
                if (selectedTournament instanceof TeamTournament) {
                    Team t1 = teams[random.nextInt(teams.length)];
                    Team t2;
                    do {
                        t2 = teams[random.nextInt(teams.length)];
                    } while (t1 == t2);
                    matches[i] = new Match(selectedTournament, t1, t2);
                } else {
                    if (selectedTournament instanceof MixedTournament) {
                        if (random.nextBoolean()) {
                            Player p1 = players[random.nextInt(players.length)];
                            Player p2;
                            do {
                                p2 = players[random.nextInt(players.length)];
                            } while (p1 == p2);
                            matches[i] = new Match(selectedTournament, p1, p2);
                        } else {
                            Team t1 = teams[random.nextInt(teams.length)];
                            Team t2;
                            do {
                                t2 = teams[random.nextInt(teams.length)];
                            } while (t1 == t2);
                            matches[i] = new Match(selectedTournament, t1, t2);
                        }
                    }
                }
            }
        }
    }

    public Player findPlayer(String username) {
        boolean found=false;
        Player player = null;

        for(int i=0; i<players.length && !found;i++) {
            if(players[i].getName().equals(username)) {
                player = players[i];
                found = true;
            }
        }
        if(!found) {
            player = new Player("",0,0);
        }
        return player;
    }

    public Team findTeam(String teamName) {
        boolean found=false;
        Team team = null;
        for(int i=0; i<teams.length && !found;i++) {
            if(teams[i].getName().equals(teamName)) {
                team = teams[i];
                found = true;
            }
        }
        if(!found) {
            team = new Team("",0);
        }
        return team;
    }

    public void showTournaments() {
        for(Tournament t : tournaments) {
            System.out.println(t);
        }
    }

    public void showPlayerRanking() {
        Arrays.sort(players);
        
        for (Player player : players) {
            if(player != null) {
                System.out.println(player);
            }
        }
    }

    public void showTeamRanking() {
        Arrays.sort(teams);

        for(Team team : teams) {
            if(team != null) {
                System.out.println(team);
            }
        }
    }
}