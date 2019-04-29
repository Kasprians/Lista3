import java.util.ArrayList;

public class Kruskal {
    ArrayList<Cell> T;

    Kruskal(int n, ArrayList<Edge> listOfEdges) {
        T = new ArrayList<Cell>();
        DisjointSet set = new DisjointSet(n);
        PriorityQueue1 h = new PriorityQueue1();
        for (int v = 1; v < n; v++) {
            set.makeSet(v);
        }
        for (Edge edge : listOfEdges) {
            h.insert(edge.getU(), edge.getV(), edge.getW());
        }
        for (int i = 1; i < n; i++) {
            Cell e = h.pop();
                if (set.find(e.getU()) != set.find(e.getV())) {
                    T.add(e);
                    set.union(e.getU(), e.getV());
                }

        }
        print();
    }

    void print() {
        double sum=0;
        for (int i = 0; i < T.size(); i++) {
            System.out.println(T.get(i).getU()+" -> "+T.get(i).getV()+" "+T.get(i).getPriority());
            sum=sum+T.get(i).getPriority();
        }
        System.out.println(sum);
    }
}
