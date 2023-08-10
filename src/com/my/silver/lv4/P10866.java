package com.my.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class P10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        MyDeQueue q = new MyDeQueue(n);

        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            int result = 0;
            switch (command) {
                case "pop_front" -> System.out.println(q.pop_front());
                case "pop_back" -> System.out.println(q.pop_back());
                case "size" -> System.out.println(q.size());
                case "empty" -> System.out.println(q.empty());
                case "front" -> System.out.println(q.front());
                case "back" -> System.out.println(q.back());
                default -> {
                    if (command.contains("push_front")) {
                        int num = Integer.parseInt(command.substring(11));
                        q.push_front(num);
                    } else {
                        int num = Integer.parseInt(command.substring(10));
                        q.push_back(num);
                    }
                }
            }
        }

    }


    private static class MyDeQueue {

        Deque<Integer> q;
        int n;
        int front;
        int back;

        public MyDeQueue(int i) {
            q = new ArrayDeque<>();
        }

        void push_front(int x){
            q.addFirst(x);
        }

        void push_back(int x){
            q.addLast(x);
        }

        int pop_front(){
            Integer n = q.pollFirst();
            return n == null ? -1 : n;
        }
        int pop_back(){
            Integer n = q.pollLast();
            return n == null ? -1 : n;
        }

        int size(){
            return q.size();
        }

        int empty(){
            return q.isEmpty() ? 1 : 0;
        }

        int front(){
            Integer n = q.peekFirst();
            return n == null ? -1 : n;
        }

        int back(){
            Integer n = q.peekLast();
            return n == null ? -1 : n;
        }



    }
}
