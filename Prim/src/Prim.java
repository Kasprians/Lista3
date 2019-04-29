
import java.util.LinkedList;

public class Prim {
    LinkedList<Edge> adj[];
    double [] distance;
    int startVertex;
    boolean[] visited;

    Prim(int n, LinkedList<Edge> adj[], int startVertex) {
        this.adj = adj;
        distance = new double[n];
        visited = new boolean [n];
        this.startVertex = startVertex;

        PriorityQueue1 h = new PriorityQueue1();
        int p[] = new int[adj.length];
        for (int a = 1; a < adj.length; a++) {
            visited[a]=false;
            distance[a] = Double.POSITIVE_INFINITY;
            h.insert(a, Double.POSITIVE_INFINITY);
            p[a] = -1;
        }

        Cell u;
        distance[startVertex] = 0;
        h.priority(startVertex, 0);

        while (!h.empty()) {
            u=h.pop();
            for(Edge vertex: adj[u.value]){
                if (h.find(vertex.neigh) != null) {
                    if (h.find(vertex.neigh).getPriority() > ( vertex.weight)) {
                        distance[vertex.neigh] = vertex.weight;
                        visited[vertex.neigh]=true;
                        h.priority(vertex.neigh, ( vertex.weight));
                        p[vertex.neigh] = u.getValue();
                    }
                }
            }
        }
        double sum=0;
        for (int i = 1; i < p.length; i++) {
            if(p[i]==-1){
                continue;
            }
            System.out.println(i+" -> "+p[i]+" "+distance[i]);
            sum=sum+distance[i];
        }
        System.out.println(sum);
    }


}
