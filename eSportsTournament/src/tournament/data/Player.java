package tournament.data;

import tournament.comparators.IComparator;

public class Player extends Participant implements IComparator<Player> {
    int level;
    float ranking;

    public Player(String name, int level, float ranking){
        super(name);
        this.level = level;
        this.ranking = ranking;
    }

    public int getLevel() {
        return level;
    }
    public float getRanking() {
        return ranking;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void setRanking(float ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString(){
        return "Player: " + super.toString() + " - Level: " + level + " - Ranking: " + ranking;
    }

    @Override
    public int compareTo(Player other) {
        return Float.compare(this.ranking, other.ranking);
    }
}
