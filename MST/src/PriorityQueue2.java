import java.util.ArrayList;
import java.util.List;

public class PriorityQueue2 {
    private List<Cell2> Q = new ArrayList<Cell2>();

    int maximum() {
        return Q.get(0).getValue();
    }

    Cell2 pop() {
        if (Q.size() < 1) {
            return null;
        } else {
            Cell2 max = Q.get(0);
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
            Cell2 tmp = Q.get(i);
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
            Cell2 tmp = Q.get(i);
            Q.set(i, Q.get(largest));
            Q.set(largest, tmp);
            heapify(largest);
        }
    }
    void priority(int x, double priority) {
        for (int i = this.Q.size() - 1; i >= 0; i -= 1) {
            if (this.Q.get(i).value == x) {
                this.decreaseKey(i, priority);
            }
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

    void insert(int x, double p) {
        int i = Q.size();
        Cell2 cell = new Cell2(x, p);
        Q.add(cell);
        while (i > 0 && Q.get(parent(i)).getPriority() > p) {
            Cell2 tmp = Q.get(parent(i));
            Q.set(parent(i), Q.get(i));
            Q.set(i, tmp);
            i = parent(i);
        }

    }


     void decreaseKey(int i, double newkey) {
        if (Q.get(i).getPriority() < newkey) {
            return;
        } else {
            Q.get(i).setPriority(newkey);
            while (i > 0 && Q.get(parent(i)).getPriority() > newkey) {
                Cell2 tmp = Q.get(i);
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
            b.append(Q.get(i).getValue() + " " + Q.get(i).getPriority());
            b.append(", ");
        }
        System.out.println(b.append(']').toString());
    }

    Cell2 getByData(int data){
        for(Cell2 queueElement: Q){
            if(queueElement.getValue()==data)
                return queueElement;
        }
        return null;
    }


}
