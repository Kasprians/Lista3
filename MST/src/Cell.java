public class Cell {
    int u,v,priority;
    public Cell(int u,int v, int priority){
        this.u=u;
        this.v=v;
        this.priority=priority;
    }

    public int getPriority() {
        return priority;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setU(int value) {
        this.u = value;
    }

    public void setV(int v) {
        this.v = v;
    }
}
