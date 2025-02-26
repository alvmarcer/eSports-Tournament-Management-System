package tournament.data;

import tournament.comparators.IComparator;

public abstract class Tournament implements IComparator<Tournament> {
    protected String name;
    protected String game;
    protected int prize;

    public Tournament(String name, String game, int prize) {
        this.name = name;
        this.game = game;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }
    public String getGame() {
        return game;
    }
    public int getPrize() {
        return prize;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setGame(String game) {
        this.game = game;
    }
    public void setPrize(int prize) {
        this.prize = prize;
    }

    @Override
    public String toString(){
        return "Tournament - " + name + " (" + game + ")" + " - Prize: " + prize + "€";
    }

    @Override
    public int compareTo(Tournament other) {
        return this.getName().compareTo(other.getName());
    }
}
