package com.company;

public class Node {
    private int key;
    private int value;

    public Node(int key, int value){
        this.key=key;
        this.value=value;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
