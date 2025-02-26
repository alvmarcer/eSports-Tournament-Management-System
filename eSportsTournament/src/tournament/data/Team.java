package tournament.data;

import tournament.comparators.IComparator;
import tournament.exceptions.FullTeamException;

public class Team extends Participant implements IComparator<Team> {
    Player[] arrayOfPlayers;
    float averageRanking;

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
            else{
                throw new FullTeamException("This team is full");
            }
        }
        calculateAverageRanking();
    }

    public void calculateAverageRanking() {
        float totalRanking = 0;
        int count = 0;

        for(Player player : arrayOfPlayers){
            if(player != null) {
                totalRanking += player.getRanking();
                count++;
            }
        }

        if(count > 0) {
            this.averageRanking = totalRanking / count;
        }
        else {
            this.averageRanking = 0;
        }
    }

    public float getAverageRanking() {
        return averageRanking;
    }

    @Override
    public String toString(){
        String result = "";
        for (int i = 0 ; i < arrayOfPlayers.length ; i++){
            result += arrayOfPlayers[i] + " ";
        }
        return super.toString() + " - " + result;
    }
    @Override
    public int compareTo(Team other) {
        return Float.compare(this.getAverageRanking(), other.getAverageRanking());
    }
}
