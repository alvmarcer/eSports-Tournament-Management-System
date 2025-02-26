package tournament.data;

public class IndividualTournament extends Tournament{
    public IndividualTournament (String name, String game, int prize){
        super(name,game,prize);
    }

    @Override
    public String toString(){
        return "Individual" + super.toString();
    }
}
