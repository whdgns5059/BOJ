package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010 {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < count ; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(combination(m, n));


        }

    }

    static int combination(int n, int m) {

        if (dp[n][m] > 0) {
            return dp[n][m];
        }

        if (n == m || m == 0) {
            return dp[n][m] = 1;
        }

        return dp[n][m] = combination(n - 1, m - 1) + combination(n - 1, m);

    }

}
