public class Cell {
    int value;
    double priority;

    public Cell(int value, double priority) {
        this.value = value;
        this.priority = priority;
    }

    public double getPriority() {
        return priority;
    }

    public int getValue() {
        return value;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
