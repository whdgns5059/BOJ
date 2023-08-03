package com.my.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//징검다리 건너기(large)
public class P22871 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stones = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            stones[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[n];
        Arrays.fill(dp,Long.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                long power = (long)(i - j) * (1 + Math.abs(stones[i] - stones[j]));
                long k = Math.max(power, dp[j]);
                dp[i] = Math.min(dp[i], k);
            }
        }
        System.out.println(dp[n-1]);
    }
}
