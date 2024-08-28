package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class P10826 {

    static BigInteger[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new BigInteger[n < 3 ? 3 : n + 1];
        Arrays.fill(dp, new BigInteger("-1"));
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");

        System.out.println(fibo(n));

    }

    private static BigInteger fibo(int n) {
        if (n == 0) {
            return dp[0];
        } else if (n == 1) {
            return dp[1];
        } else if (!dp[n].equals(new BigInteger("-1"))) {
            return dp[n];
        }

        return dp[n] = fibo(n - 1).add(fibo(n - 2));
    }

}
