package com.my.backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[12];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            int num = Integer.parseInt(br.readLine());

            for(int k = 4 ; k <= num ; k++){

                if(dp[k] != 0){
                    continue;
                }
                dp[k] = dp[k-1] + dp[k-2] + dp[k-3];
            }
            sb.append(dp[num]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
