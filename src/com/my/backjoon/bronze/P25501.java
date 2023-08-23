package com.my.backjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25501 {
    static int cnt;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n; i++){
            String str = br.readLine();
            cnt = 0;
            int result = isPalindrome(str);
            System.out.println(result + " " + cnt);
        }

    }

    private static int isPalindrome(String str) {
        return recursion(str, 0, str.length()-1);
    }

    private static int recursion(String str, int i, int j) {
        cnt++;
        if(i >= j){
            return 1;
        }else if(str.charAt(i) != str.charAt(j)){
            return 0;
        }else{
            return recursion(str, i + 1, j - 1);
        }
    }
}
