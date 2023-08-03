package com.my.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] commands = new String[n];
        for(int i = 0 ; i < n ; i++){
            commands[i] = br.readLine();
        }

        MyStack stack = new MyStack();

        for(String s : commands){
            if(s.contains("push")){
                String[] push = s.split(" ");
                stack.push(Integer.parseInt(push[1]));
            }else if(s.equals("pop")){
                System.out.println(stack.pop());
            }else if(s.equals("size")){
                System.out.println(stack.size());
            }else if(s.equals("empty")){
                System.out.println(stack.empty());
            }else if(s.equals("top")){
                System.out.println(stack.top());
            }
        }

    }

    private static class MyStack {

        int[] arr;
        int pointer;

        MyStack(){
            arr = new int[10001];
            pointer = 0;
        }

        void push(int n){
            arr[pointer++] = n;
        }

        int pop(){
            if(pointer == 0){
                return -1;
            }
            int result = arr[pointer-1];
            arr[pointer-1] = 0;
            pointer--;
            return result;
        }

        int size(){
            return pointer;
        }

        int empty(){
            return pointer == 0 ? 1 : 0;
        }

        int top(){
            if(pointer == 0){
                return -1;
            }
            int result = arr[pointer-1];
            return result;
        }




    }
}
