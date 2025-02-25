package tournament.data;

public class MixedTournament extends Tournament {
    String gameMode;

    public MixedTournament(String name, String game, int prize, String gameMode){
        super(name, game, prize);
        this.gameMode = gameMode;
    }

    public String getGameMode(){
        return gameMode;
    }

    public void setGameMode(String gameMode)
    {
        this.gameMode = gameMode;
    }

    @Override
    public String toString(){
        return "Mixed tournament" + super.toString() + " - game mode: " + gameMode;
    }
}
