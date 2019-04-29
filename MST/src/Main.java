import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner reader = new Scanner(System.in);
        int n = Integer.parseInt(reader.nextLine());
        int m = Integer.parseInt(reader.nextLine());

        if (args[0].equals("-p")) {
            String[] split;
            ArrayList<DirectedEdge> listOfEdges = new ArrayList<>();
            for(int a=0; a<m; a++){
                split = reader.nextLine().split("\\s+");
                listOfEdges.add(
                        new DirectedEdge(Integer.parseInt(split[0]),
                                Integer.parseInt(split[1]),
                                Integer.parseInt(split[2])
                        )
                );
                listOfEdges.add(
                        new DirectedEdge(Integer.parseInt(split[1]),
                                Integer.parseInt(split[0]),
                                Integer.parseInt(split[2])
                        )
                );
            }
            Prim2 dijkstraAlgorithm = new Prim2(n+1, listOfEdges, 1);
        }else if(args[0].equals("-k")){
            String[] split;
            ArrayList<Edge> listOfEdges = new ArrayList<>();
            for(int a=0; a<m; a++){
                split = reader.nextLine().split("\\s+");
                listOfEdges.add(
                        new Edge(Integer.parseInt(split[0]),
                                Integer.parseInt(split[1]),
                                Integer.parseInt(split[2])
                        )
                );
            }
            Kruskal kruskal= new Kruskal(m, listOfEdges);
        }
    }
}
