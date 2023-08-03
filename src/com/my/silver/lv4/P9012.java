package com.my.silver.lv4;

import java.io.*;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class P9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());


        for(int i = 0 ; i < n ; i++){
            Stack<String> stack = new Stack<>();

            if(isVPS(br.readLine())){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }

        br.close();
        bw.close();

    }

    private static boolean isVPS(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else{
                try {
                    stack.pop();
                }catch (EmptyStackException e){
                    return false;
                }

            }
        }

        return stack.size() == 0;

    }
}

