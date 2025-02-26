package tournament.data;

import tournament.comparators.IComparator;

public class Match implements IComparator<Match> {
    Tournament tournament;
    Participant participant1;
    Participant participant2;
    String result;

    public Match(Tournament tournament, Participant participant1, Participant participant2) {
        this.tournament = tournament;
        this.participant1 = participant1;
        this.participant2 = participant2;
        result = "Pending";
    }

    public Tournament getTournament() {
        return tournament;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString(){
        return tournament + " - " + participant1 + " VS. " + participant2 + " - Result: " + result;
    }

    @Override
    public int compareTo(Match other) {
        return this.getTournament().name.compareTo(other.getTournament().name);
    }
}
