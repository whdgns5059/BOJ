package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P23253 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {

            int k = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {

                int num = Integer.parseInt(stk.nextToken());
                if (num > tmp) {
                    System.out.println("No");
                    System.exit(0);
                }

                tmp = num;

            }
        }

        System.out.println("Yes");


    }

}
