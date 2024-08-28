package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14606 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 3];
        dp[1] = 0;
        dp[2] = 1;

        System.out.println(box(n));

    }

    private static int box(int n) {
        if (n == 1) {
            return dp[1];
        } else if (n == 2) {
            return dp[2];
        } else if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = (n / 2 * (n - n / 2)) + box(n / 2) + box(n - n / 2);


    }

}
