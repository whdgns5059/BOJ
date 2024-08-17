package com.my.backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14495 {

    static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n + 3];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        System.out.println(fibo(n));

    }

    private static long fibo(int n) {

        if (dp[n] != 0) {
            return dp[n];
        }

        if (n == 1 || n == 2 || n == 3) {
            return 1;
        }
        return dp[n] = fibo(n - 1) + fibo(n - 3);
    }

}
