import java.util.ArrayList;
import java.util.List;

public class PriorityQueue1 {
    private List<Cell> Q = new ArrayList<Cell>();



    Cell pop() {
        if (Q.size() < 1) {
            return null;
        } else {
            Cell max = Q.get(0);
            Q.set(0, Q.get(Q.size() - 1));
            heapify(0);
            Q.remove(Q.size() - 1);
            return max;
        }
    }

    void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int min = i;
        if (left < Q.size() && Q.get(left).getPriority() < Q.get(min).getPriority()) {
            min = left;
        }
        if (right < Q.size() && Q.get(right).getPriority() < Q.get(min).getPriority()) {
            min = right;
        }
        if (min != i) {
            Cell tmp = Q.get(i);
            Q.set(i, Q.get(min));
            Q.set(min, tmp);
            heapify(min);
        }
    }

    void heapup(int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left < Q.size() && Q.get(left).getPriority() > Q.get(largest).getPriority()) {
            largest = left;
        }
        if (right < Q.size() && Q.get(right).getPriority() > Q.get(largest).getPriority()) {
            largest = right;
        }
        if (largest != i) {
            Cell tmp = Q.get(i);
            Q.set(i, Q.get(largest));
            Q.set(largest, tmp);
            heapify(largest);
        }
    }


    boolean empty() {
        return (Q.size() == 0);
    }

    int parent(int i) {
        return (int) ((i - 1) / 2);
    }

    private int left(int idx) {
        return 2 * idx + 1;
    }

    private int right(int idx) {
        return 2 * (idx + 1);
    }

    void insert(int u,int v, int p) {
        int i = Q.size();
        Cell cell = new Cell(u,v, p);
        Q.add(cell);
        while (i > 0 && Q.get(parent(i)).getPriority() > p) {
            Cell tmp = Q.get(parent(i));
            Q.set(parent(i), Q.get(i));
            Q.set(i, tmp);
            i = parent(i);
        }

    }


     void decreaseKey(int i, int newkey) {
        if (Q.get(i).getPriority() < newkey) {
            return;
        } else {
            Q.get(i).setPriority(newkey);
            while (i > 0 && Q.get(parent(i)).getPriority() > newkey) {
                Cell tmp = Q.get(i);
                Q.set(i, Q.get(parent(i)));
                Q.set(parent(i), tmp);
                i= parent(i);
            }
            heapify(0);
        }
    }

    public void print() {
        int iMax = Q.size(), i;
        if (iMax == -1)
            System.out.print("[]");

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (i = 0; i < iMax; i++) {
            b.append(Q.get(i).getU() + " " + Q.get(i).getPriority());
            b.append(", ");
        }
        System.out.println(b.append(']').toString());
    }

/*    Cell getByData(int data){
        for(Cell queueElement: Q){
            if(queueElement.getValue()==data)
                return queueElement;
        }
        return null;
    }
*/

}
