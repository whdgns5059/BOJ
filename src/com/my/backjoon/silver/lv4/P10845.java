package com.my.backjoon.silver.lv4;

import java.io.*;

public class P10845 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        MyQueue queue = new MyQueue();

        for(int i = 0 ; i < n ; i++){
            String s = br.readLine();
            switch (s){
                case "pop":
                    System.out.println(queue.pop());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.empty());
                    break;
                case "front":
                    System.out.println(queue.front());
                    break;
                case "back":
                    System.out.println(queue.back());
                    break;
                default:
                    int num = Integer.parseInt(s.split(" ")[1]);
                    queue.push(num);
                    break;
            }

        }

        br.close();

    }

    private static class MyQueue {

        int[] data;
        int front;
        int rear;

        MyQueue(){
            data = new int[10001];
            front = 0;
            rear = 0;
        }

        void push(int i){
            data[rear++] = i;
        }

        int pop(){
            if(rear == front){
                return -1;
            }

            int result = data[front];
            data[front++] = 0;
            return result;
        }

        int size(){
            return rear - front;
        }

        int empty(){
            return rear == front ? 1 : 0;
        }

        int front(){
            return rear != front ? data[front] : -1;
        }

        int back(){
            return rear != front ? data[rear-1] : -1;
        }

    }
}
