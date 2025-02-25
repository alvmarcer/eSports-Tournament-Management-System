package tournament.data;

public class Player extends Participant{
    int level;
    float ranking;

    public Player(String name, int level, float ranking){
        super(name);
        this.level = level;
        this.ranking = ranking;
    }

    public int getLevel(){
        return level;
    }
    public float getRanking(){
        return ranking;
    }

    public void setLevel(int level){
        this.level = level;
    }
    public void setRanking(float ranking){
        this.ranking = ranking;
    }

    @Override
    public String toString(){
        return "Player: " + super.toString() + " - Level: " + level + " - " + "Ranking: " + ranking;
    }
}
