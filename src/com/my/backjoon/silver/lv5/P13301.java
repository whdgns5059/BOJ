package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P13301 {

    static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n < 2 ? 3 : n + 1];
        dp[0] = 0;
        dp[1] = 4;
        dp[2] = 6;

        System.out.println(fibo(n));


    }

    private static long fibo(int n) {
        if (n == 0) {
            return dp[0];
        } else if (n == 1) {
            return dp[1];
        } else if (n == 2) {
            return dp[2];
        } else if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fibo(n - 1) + (fibo(n - 2));
    }

}
