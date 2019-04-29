import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int n = Integer.parseInt(reader.nextLine());
        int m = Integer.parseInt(reader.nextLine());
        LinkedList<Edge> adj[]=new LinkedList[n+1];
        if (args[0].equals("-p")) {
            String[] split;

            for (int i = 0; i <= n; ++i)
                adj[i] = new LinkedList();
            for (int a = 0; a < m; a++) {
                split = reader.nextLine().split("\\s+");
                adj[Integer.parseInt(split[0])].add(new Edge(Integer.parseInt(split[1]), Double.parseDouble(split[2])));
                adj[Integer.parseInt(split[1])].add(new Edge(Integer.parseInt(split[0]), Double.parseDouble(split[2])));
            }
        }
        Prim prim = new Prim(n+1,adj,1);
    }
}
