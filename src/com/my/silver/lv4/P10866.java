package com.my.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        MyQueue q = new MyQueue(n+1);

        for(int i = 0 ; i < n ; i++){

        }

    }


    private static class MyQueue {

        int[] arr;
        int front;
        int back;

        public MyQueue(int i) {
            arr = new int[i];
            front = 0;
            back = 0;
        }

        void push_front(int x){

            arr[front++] = x;
        }

        void push_back(int x){
            arr[back--] = x;
        }

        int size(){
            return 0;
        }

        int empty(){
            return 0;
        }

        int front(){
            return 0;
        }

        int back(){
            return 0;
        }


    }
}
