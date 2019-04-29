import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner reader = new Scanner(System.in);
        int n = Integer.parseInt(reader.nextLine());
        int m = Integer.parseInt(reader.nextLine());
        String[] split;
        ArrayList<DirectedEdge> listOfEdges = new ArrayList<>();
        for(int a=0; a<m; a++){
            split = reader.nextLine().split("\\s+");
            listOfEdges.add(
                    new DirectedEdge(Integer.parseInt(split[0]),
                            Integer.parseInt(split[1]),
                            Double.parseDouble(split[2])
                    )
            );
        }

       Dijkstra dijkstraAlgorithm = new Dijkstra(n+1, listOfEdges, Integer.parseInt(reader.nextLine()));
       // dijkstraAlgorithm.runAlgorithm();
    }
}
