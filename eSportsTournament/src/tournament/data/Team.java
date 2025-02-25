package tournament.data;

public class Team extends Participant{
    Player[] arrayOfPlayers;

    public Team(String name, int members){
        super(name);
        if(members <= 2){
            arrayOfPlayers = new Player[2];
        } else if (members > 5) {
            arrayOfPlayers = new Player[5];
        } else {
            arrayOfPlayers = new Player[members];
        }
    }

    public void addPlayer(Player p){
        for(int i = 0 ; i < arrayOfPlayers.length ; i++){
            if(arrayOfPlayers[i] == null) {
                arrayOfPlayers[i] = p;
            }
        }
    }

    @Override
    public String toString(){
        String result = "";
        for (int i = 0 ; i < arrayOfPlayers.length ; i++){
            result += arrayOfPlayers[i] + " ";
        }
        return super.toString() + " - " + result;
    }
}
