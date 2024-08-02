package com.my.backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1259 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String s = br.readLine();
            if(s.equals("0")){
                br.close();
                return;
            }

            isPalindrome(s, 0);

        }

    }
    static void isPalindrome(String str, int i){
        if(i >= str.length() -1 - i){
            System.out.println("yes");
            return;
        }

        if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
            System.out.println("no");
            return;
        }
        isPalindrome(str, i + 1);
    }
}
