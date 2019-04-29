
import java.util.ArrayList;

public class Dijkstra {

    ArrayList<DirectedEdge> neighbourList[];
    double [] distance;
    int startVertex;

    Dijkstra(int n, ArrayList<DirectedEdge> listOfEdges, int startVertex) {
        neighbourList = new ArrayList[n];
        distance=new double[n];
        this.startVertex = startVertex;

        for (int a = 1; a < n; a++) {
            neighbourList[a] = new ArrayList<DirectedEdge>();
        }
        for (DirectedEdge listOfEdge : listOfEdges) {
            neighbourList[listOfEdge.getFrom()].add(listOfEdge);
        }
        PriorityQueue1 h = new PriorityQueue1();
        int p[] = new int[neighbourList.length];
        for (int a = 1; a < neighbourList.length; a++) {
            distance[a]=Double.POSITIVE_INFINITY;
            h.insert(a, Double.POSITIVE_INFINITY);
            p[a] = -1;
        }

        Cell u;
        distance[startVertex]=0;
        h.priority(startVertex, 0);

        while(!h.empty()){
            u = h.pop();
            System.out.println("id_celu " + u.getValue()+ " waga_drogi " + u.getPriority());
            for (DirectedEdge vertex : neighbourList[u.value]) {
                if (h.find(vertex.getTo()) != null) {
                    if (h.find(vertex.getTo()).getPriority() > (u.getPriority() + vertex.getWeight())) {
                        distance[vertex.getTo()]=u.getPriority() + vertex.getWeight();
                        h.priority(vertex.getTo(), (u.getPriority() + vertex.getWeight()));
                        p[vertex.getTo()] = u.getValue();
                    }
                }
            }

        }

        for (int i=0;i<p.length;i++) {
            System.out.println(p[i]);
        }

    }


}


