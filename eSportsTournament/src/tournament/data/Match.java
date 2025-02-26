package tournament.data;

public class Match {
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

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString(){
        return tournament + " - " + participant1 + " VS. " + participant2 + " - Result: " + result;
    }
}
