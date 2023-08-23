package com.my.backjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10818 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");

        br.close();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String s : arr) {
            int i = Integer.parseInt(s);

            min = min > i ? i : min;
            max = max < i ? i : max;

        }

        System.out.println(min + " " + max);

    }
}
