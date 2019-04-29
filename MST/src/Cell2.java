public class Cell2 {
    int value;
    double priority;

    public Cell2(int value, double priority) {
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
