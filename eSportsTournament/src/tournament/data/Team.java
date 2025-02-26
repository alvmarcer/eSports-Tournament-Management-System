package tournament.data;

import tournament.comparators.IComparator;
import tournament.exceptions.FullTeamException;

public class Team extends Participant implements IComparator<Team> {
    Player[] arrayOfPlayers;
    float averageRanking;

    public Team(String name, int members) {
        super(name);
        if(members <= 2){
            arrayOfPlayers = new Player[2];
        } else if (members >= 5) {
            arrayOfPlayers = new Player[5];
        } else {
            arrayOfPlayers = new Player[members];
        }
    }

    public void addPlayer(Player p) {
        boolean nullFound = false;

        for(int i = 0 ; i < arrayOfPlayers.length && !nullFound ; i++){
            if(arrayOfPlayers[i] == null) {
                arrayOfPlayers[i] = p;
                nullFound = true;
            }
        }

        if(!nullFound) {
            throw new FullTeamException("This team is full");
        }

        calculateAverageRanking();
    }

    public void calculateAverageRanking() { // This method could be private
        float totalRanking = 0;
        int count = 0;

        for(Player player : arrayOfPlayers) {
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
    public String toString() {
        String result = "";
        for (int i = 0 ; i < arrayOfPlayers.length ; i++){
            result += "Player: " + arrayOfPlayers[i] + " ";
        }

        int numberOfPlayers = 0;
        for(int i=0; i<arrayOfPlayers.length; i++) {
            if(arrayOfPlayers[i] != null) {
                numberOfPlayers++;
            }
        }

        return super.toString() + " - Members: "+ numberOfPlayers + "/5: " + result;
    }

    @Override
    public int compareTo(Team other) {
        return Float.compare(this.getAverageRanking(), other.getAverageRanking());
    }
}
