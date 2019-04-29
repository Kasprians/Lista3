public class DirectedEdge {
    private final int from;
    private final int to;
    private final int weight;

    public DirectedEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%d->%d (%d) ", from, to, weight);
    }
}