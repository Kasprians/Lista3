public class DisjointSet {
    int[] rank, parent;
    int n;


    public DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
    }

    void makeSet(int x) {
            parent[x] = x;
            rank[x]=0;
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }


    void union(int x, int y) {

        int xRoot = find(x), yRoot = find(y);


        if (xRoot == yRoot) {
            return;
        }

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;

        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot;
        }else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}