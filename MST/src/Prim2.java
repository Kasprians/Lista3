

import java.util.ArrayList;

public class Prim2 {

    ArrayList<DirectedEdge> neighbourList[];
    double[] cost;
    int startVertex;
    double costSum;
    boolean visited[];

    Prim2(int n, ArrayList<DirectedEdge> listOfEdges, int startVertex) {
        neighbourList = new ArrayList[n];
        cost = new double[n];
        this.startVertex = startVertex;

        for (int a = 1; a < n; a++) {
            neighbourList[a] = new ArrayList<DirectedEdge>();
        }
        for (DirectedEdge listOfEdge : listOfEdges) {
            neighbourList[listOfEdge.getFrom()].add(listOfEdge);
           /* DirectedEdge edge2 = new DirectedEdge(listOfEdge.getTo(), listOfEdge.getFrom(), listOfEdge.getWeight());
            neighbourList[listOfEdge.getTo()].add(edge2);*/
        }

        for (DirectedEdge listOfEdge : listOfEdges){
            System.out.println(listOfEdge.getFrom()+" to "+listOfEdge.getTo());
        }
        PriorityQueue2 h = new PriorityQueue2();
        int p[] = new int[neighbourList.length];
        for (int a = 1; a < neighbourList.length; a++) {
            cost[a] = Double.POSITIVE_INFINITY;
            h.insert(a, Double.POSITIVE_INFINITY);
            p[a] = -1;
        }

        Cell2 u;
        cost[startVertex] = 0;
        h.priority(startVertex, 0);
        visited = new boolean[n];
        for (int i = 1; i < n; i++) {
            visited[i] = false;
        }
        visited[1] = true;
        while (!h.empty()) {
            u = h.pop();
            System.out.println("id_u " +u.getValue()+" waga_drogi " + u.getPriority());
            for (DirectedEdge vertex : neighbourList[u.value]) {
                if (h.getByData(vertex.getTo()) != null) {
                    if (h.getByData(vertex.getTo()).getPriority() > (u.getPriority() + vertex.getWeight())) {
                        cost[vertex.getTo()] = vertex.getWeight();
                        h.priority(vertex.getTo(), (vertex.getWeight()));
                        p[vertex.getTo()] = u.getValue();

                    }
                }
            }
            double min = cost[2];
            int k = 2;
            boolean printf = false;
            for (int i = 1; i < n; i++) {
                if (!visited[i]) {
                    if (cost[i] <= min) {
                        min = cost[i];
                        k = i;
                        printf = true;
                    }
                }
            }
            if (printf) {
                System.out.println(p[k] + " -> " + k);
                visited[k] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            costSum = costSum + cost[i];
        }
        System.out.println(costSum);
    }


}


