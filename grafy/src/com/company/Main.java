package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        while(m>0){
            String operation = input.nextLine();
            String[] splited = operation.split("\\s+");
            switch(splited[0]) {
                case "insert":{
                    priorityQueue.insert(Integer.parseInt(splited[1]),(Integer.parseInt(splited[2])));
                    break;
                }
                case "empty":{
                    if(priorityQueue.isEmpty()){
                        System.out.println("true");
                    }else{
                        System.out.println("false");
                    }
                    break;
                }
                case "top":{
                    priorityQueue.top();
                    break;
                }
                case "pop":{
                    priorityQueue.pop();
                    break;
                }
                case "priority":{
                    priorityQueue.priority(Integer.parseInt(splited[1]),(Integer.parseInt(splited[2])));
                    break;
                }case "print":{
                    priorityQueue.print();
                    break;
                }
            }

            m--;
        }
    }
}
