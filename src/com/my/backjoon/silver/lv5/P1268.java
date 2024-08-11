package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1268 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] students = new int[n][5];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] counts = new int[n];
        boolean[] friends = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {

                int ban = students[i][j];

                for (int k = 0; k < n; k++) {
                    if (k == i) {
                        continue;
                    } else if (ban == students[k][j]) {
                        friends[k] = true;
                    }
                }
            }

            for (int l = 0; l < n; l++) {
                if (friends[l]) {
                    counts[i]++;
                }
            }

            friends = new boolean[n];
        }

        int max = -1;
        int num = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (max <= counts[i]) {
                max = counts[i];
                num = i;
            }
        }

        System.out.println(num + 1);


    }

}
