package tournament.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import tournament.data.Match;
import tournament.data.Player;
import tournament.data.Team;
import tournament.data.Tournament;

public class Main {
    final static Scanner sc = new Scanner(System.in);

    public static void menu() {
        System.out.println(" 1. View available tournaments ordered by name.");
        System.out.println(" 2. View players information ordered by ranking and name.");
        System.out.println(" 3. View teams information ordered by ranking.");
        System.out.println(" 4. Add a new player to a team.");
        System.out.println(" 5. Find an exact player by name.");
        System.out.println(" 6. Find players.");
        System.out.println(" 7. Find teams.");
        System.out.println(" 8. Show all the matches ordered by tournament name.");
        System.out.println(" 9. Update the result of the matches pending.");
        System.out.println("10. Exit.");
    }

    public static Player addPlayer() {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Level: ");
        int level = sc.nextInt();

        System.out.print("Ranking: ");
        float ranking = sc.nextFloat();

        sc.nextLine(); // To prevent errors from the scanner
        return new Player(name,level,ranking);
    }

    public static void main(String[] args) {
        TournamentManager tournamentManager = new TournamentManager();
        tournamentManager.initialize();

        boolean menu = true;

        while(menu) {
            menu();
            System.out.print("Choose an option: ");
            String option = sc.nextLine();

            System.out.println(); // To put space between the option selector and the result

            switch (option) {
                case "1":
                    tournamentManager.showTournaments();

                    System.out.println();

                    Arrays.sort(tournamentManager.getTournaments(), new Comparator<Tournament>() {
                        @Override
                        public int compare(Tournament t1, Tournament t2) {
                            return t1.getName().compareTo(t2.getName());
                        }
                    });

                    tournamentManager.showTournaments();
                    break;
                case "2":
                    tournamentManager.showPlayerRanking();

                    System.out.println();

                    Arrays.sort(tournamentManager.getPlayers(), new Comparator<Player>() {
                        @Override
                        public int compare(Player p1, Player p2) {
                            int result = Float.compare(p1.getRanking(), p2.getRanking());

                            if(result == 0) {
                                result = p1.getName().compareTo(p2.getName());
                            }

                            return result;
                        }
                    });

                    tournamentManager.showPlayerRanking();
                    break;
                case "3":
                    tournamentManager.showTeamRanking();

                    System.out.println();

                    Arrays.sort(tournamentManager.getTeams(), new Comparator<Team>() {
                        @Override
                        public int compare(Team t1, Team t2) {
                            return Float.compare(t1.getAverageRanking(), t2.getAverageRanking());
                        }
                    });

                    tournamentManager.showTeamRanking();
                    break;
                case "4":
                    tournamentManager.showTeamRanking();
                    System.out.print("Select a team (name): ");
                    String teamName = sc.nextLine();

                    boolean teamFound = false;
                    int position = 0;
                    for(int i = 0; i<tournamentManager.getTeams().length && !teamFound; i++) {
                        if(tournamentManager.getTeams()[i].getName().toLowerCase().compareTo(teamName.toLowerCase()) == 0) {
                            position = i;
                            teamFound = true;
                        }
                    }

                    System.out.println(); // Space between the search and the creation of a player or the error

                    if(teamFound) {
                        Player player = addPlayer();
                        tournamentManager.getTeams()[position].addPlayer(player);
                    }
                    else {
                        System.out.println("ERROR: Team not found.");
                    }
                    break;
                case "5":
                    tournamentManager.showPlayerRanking();
                    System.out.print("Search a player (name): ");
                    String playerName = sc.nextLine();

                    System.out.println();

                    boolean playerFound = false;
                    for(int i=0; i<tournamentManager.getPlayers().length && !playerFound; i++) {
                        if(tournamentManager.getPlayers()[i].getName().compareTo(playerName) == 0) {
                            System.out.println(tournamentManager.getPlayers()[i]);
                            playerFound = true;
                        }
                    }

                    if(!playerFound) {
                        System.out.println("ERROR: Player not found.");
                    }
                    break;
                case "6":
                    tournamentManager.showPlayerRanking();

                    System.out.print("Search a player (by coincidence in the name with the next text): ");
                    String playerNameCoincidence = sc.nextLine();

                    System.out.println();

                    boolean playerCoincidenceFound = false;
                    for(int i=0; i<tournamentManager.getPlayers().length && !playerCoincidenceFound; i++) {
                        if(tournamentManager.getPlayers()[i].getName().contains(playerNameCoincidence)) {
                            System.out.println(tournamentManager.getPlayers()[i]);
                            playerCoincidenceFound = true;
                        }
                    }

                    if(!playerCoincidenceFound) {
                        System.out.println("ERROR: Player not found.");
                    }
                    break;
                case "7":
                    tournamentManager.showTeamRanking();

                    System.out.print("Search a team (by coincidence in the name with the next text): ");
                    String teamNameCoincidence = sc.nextLine();

                    System.out.println();

                    boolean teamCoincidenceFound = false;
                    for(int i=0; i<tournamentManager.getTeams().length && !teamCoincidenceFound; i++) {
                        if(tournamentManager.getTeams()[i].getName().contains(teamNameCoincidence)) {
                            System.out.println(tournamentManager.getTeams()[i]);
                            teamCoincidenceFound = true;
                        }
                    }

                    if(!teamCoincidenceFound) {
                        System.out.println("ERROR: Team not found.");
                    }
                    break;
                case "8":
                    tournamentManager.showMatches();

                    System.out.println();

                    Arrays.sort(tournamentManager.getMatches(), new Comparator<Match>() {
                        @Override
                        public int compare(Match m1, Match m2) {
                            return m1.getTournament().getName().compareTo(m2.getTournament().getName());
                        }
                    });

                    tournamentManager.showMatches();
                    break;
                case "9":
                    tournamentManager.inputResult(); // Added in TournamentManager

                    System.out.println();

                    System.out.print("Number of the pending match to change status: ");
                    int index = sc.nextInt()-1;
                    sc.nextLine();

                    if(index >= 0 && index < tournamentManager.getMatches().length && tournamentManager.getMatches()[index].getResult().equals("Pending")) {
                        System.out.print("New result of the match: ");
                        tournamentManager.getMatches()[index].setResult(sc.nextLine());
                    }
                    else {
                        System.out.println("ERROR: Not a valid index or not a pending match.");
                    }
                    break;
                case "10":
                    System.out.println("Leaving...");
                    menu = false;
                    break;
                default:
                    System.out.println("ERROR: Not a valid option.");
                    break;
            }

            System.out.println(); // To put space between the result and the menu (again)
        }

        sc.close();
    }
}