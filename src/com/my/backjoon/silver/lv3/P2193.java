package com.my.backjoon.silver.lv3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //이친수가 아니면 true;
        int[] dp = new int[n+1];
        dp[1] = 1;
        int count = 1;
        for(int i = 1 ; i < n+1 ; i++){

            int num = i;
            while(num > 0){

            }
            

        }
        System.out.println(dp[n]);

    }
}
