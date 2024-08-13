package com.my.backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;

        char[][] chars = new char[5][];
        int maxlong = 0;
        for (int i = 0; i < n; i++) {
            chars[i] = br.readLine().toCharArray();
            if (chars[i].length > maxlong) {
                maxlong = chars[i].length;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < maxlong; j++) {
            for (int i = 0; i < n; i++) {

                if (j >= chars[i].length) {
                    continue;
                }
                sb.append(chars[i][j]);


            }
        }
        System.out.println(sb);


    }

}
