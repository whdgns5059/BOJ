package com.my.backjoon.bronze.lv1;

import java.util.Arrays;
import java.util.Scanner;

public class P2748 {

    static long[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new long[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 1;
        long result = fibonacci(n);

        System.out.println(result);


    }
    private static long fibonacci(int n) {

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = fibonacci(n-1) + fibonacci(n-2);
        return dp[n];
    }
}
