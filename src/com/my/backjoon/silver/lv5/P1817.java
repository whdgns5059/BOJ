package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1817 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println(0);
            System.exit(0);
        }

        st = new StringTokenizer(br.readLine());

        int count = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {

            int book = Integer.parseInt(st.nextToken());

            if (sum + book > m) {
                sum = 0;
                count++;
            }
            sum += book;


        }

        System.out.println(count);

    }

}
