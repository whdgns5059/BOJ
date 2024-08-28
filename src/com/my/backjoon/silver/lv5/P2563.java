package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2563 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            paper[i][0] = Integer.parseInt(st.nextToken());
            paper[i][1] = Integer.parseInt(st.nextToken());
        }

        int sumOfArea = 0;

        for (int i = 1; i < n; i++) {

            int area = 0;

            if (paper[i - 1][0] + 10 <= paper[i][0] || paper[i - 1][0] >= paper[i][0] + 10
                || paper[i - 1][1] + 10 <= paper[i][1] || paper[i - 1][1] >= paper[i][1] + 10
            ) {
                continue;
            } else {

                sumOfArea += area;
            }


        }


    }

}
