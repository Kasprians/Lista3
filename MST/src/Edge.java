public class Edge {
    private int u, v;
    private int w;

    Edge(int vertex1, int vertex2, int weight){
        this.u = vertex1;
        this.v = vertex2;
        this.w = weight;
    }

    public int getW() {
        return w;
    }

    public int getV() {
        return v;
    }

    public int getU() {
        return u;
    }
}
