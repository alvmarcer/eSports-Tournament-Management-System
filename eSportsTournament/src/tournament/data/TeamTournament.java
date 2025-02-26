package tournament.data;

public class TeamTournament extends Tournament{
    int playersPerTeam;

    public TeamTournament(String name, String game, int prize, int playersPerTeam){
        super(name, game, prize);
        this.playersPerTeam = playersPerTeam;
    }

    public int getPlayersPerTeam(){
        return playersPerTeam;
    }

    public void setPlayersPerTeam(int playersPerTeam){
        this.playersPerTeam = playersPerTeam;
    }

    @Override
    public String toString(){
        return "Team" + super.toString() + " - Players: " + playersPerTeam;
    }
}
