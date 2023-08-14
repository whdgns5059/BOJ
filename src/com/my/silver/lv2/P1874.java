package com.my.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1874 {
    static List<String> resultList;
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int[] sequence = new int[n];
        for(int i = 0 ; i < n ; i++){
            sequence[i] = Integer.parseInt(br.readLine());
        }
        resultList = new ArrayList<>();
        stack = new Stack<>();

        int sIndex = 0;
        int number = 1;
        while(sIndex < n){

            int sNum = sequence[sIndex++];

            while(number <= sNum){
                add(number++);
            }

            if(!stack.isEmpty()){
                if(stack.peek() != sNum){
                    System.out.println("NO");
                    return;
                }
                pop();
            }

        }
        StringBuilder sb = new StringBuilder();
        for(String s : resultList){
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    static void add(int num){
        resultList.add("+");
        stack.add(num);
    }

    static int pop(){
        resultList.add("-");
        return stack.pop();
    }


}
