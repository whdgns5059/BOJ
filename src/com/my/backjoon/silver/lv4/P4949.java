package com.my.backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4949 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = "";
        StringBuilder result = new StringBuilder();
        while(true){

            s = br.readLine();
            if(s.equals(".")){
                break;
            }


            if(isPair(s)){
                result.append("yes").append("\n");
            }else{
                result.append("no").append("\n");
            }


        }

        System.out.println(result.toString());

    }

    private static boolean isPair(String string) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < string.length() ; i++){

            char c = string.charAt(i);

            if(c == '(' || c == '['){
                stack.push(c);
            }else if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() != '('){
                    return false;
                }
                stack.pop();
            }else if(c == ']'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() != '['){
                    return false;
                }
                stack.pop();
            }


        }

        return stack.isEmpty();
    }
}
