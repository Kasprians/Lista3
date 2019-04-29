package com.company;

import java.util.ArrayList;

public class PriorityQueue<T> {

    ArrayList<Node> A;
    int size;

    public PriorityQueue(){
        this.size=0;
        A = new ArrayList<>();
    }

    void min_heapify( int n, int i)
    {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && A.get(l).getKey() < A.get(smallest).getKey())
            smallest = l;
        if (r < n && A.get(r).getKey() < A.get(smallest).getKey())
            smallest = r;
        if (smallest != i) {
            Node swap = A.get(i);
            A.set(i,A.get(smallest));
            A.set(smallest,swap);

            min_heapify( n, smallest);
        }
    }
    int parent(int i){
        return (i-1)/2;
    }

    boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }
    void top(){
        if(size==0){
            System.out.println();
        }else{
            System.out.println(A.get(0).getValue());
        }
    }

    int left(int i){
        return (2*i)+1;
    }

    int right(int i){
        return (2*i)+2;
    }

    void pop(){
        if(size==0){
            System.out.println();
        }else{
            System.out.println(extract_min().getValue());
        }
    }

    Node extract_min(){
        Node max= A.get(0);
        A.set(0,A.get(size-1));
        size=size-1;
        min_heapify(size,0);
        return max;
    }

    void print(){
        for(int i=0;i<size;i++){
            System.out.println("value_"+i+" = "+A.get(i).getValue()+"  key_"+i+" = "+A.get(i).getKey());
        }
    }
    void insert(int value,int key){
        A.add(new Node(key,value));
        int i=size;
        size=size+1;
        while( i>0 && A.get(parent(i)).getKey()>A.get(i).getKey()){
            Node temp = A.get(parent(i));
            A.set(parent(i),A.get(i));
            A.set(i,temp);
            i=parent(i);
        }
    }
    void delete_(int i){
        A.set(i,A.get(size-1));
        A.remove(size-1);
        size--;
        min_heapify(size,i);
    }

    void priority(int value, int key){
        for(int i = 0; i<size; i++){
            if(A.get(i).getValue()==value){
                if(A.get(i).getKey() > key){
                    delete_(i);
                    insert(value, key);
                    i--;
                }
            }
        }
    }

    void decrease_key(int i, int new_priority){
        if(A.get(i).getKey() < new_priority){
            return;
        }else{
            A.get(i).setKey( new_priority);
            min_heapify(size,i);
        }
    }

}
