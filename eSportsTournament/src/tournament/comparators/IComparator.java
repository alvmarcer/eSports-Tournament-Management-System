package tournament.comparators;

public interface IComparator<O> extends Comparable<O> {
    public int compareTo(O o1);
}

