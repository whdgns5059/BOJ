package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();

        int counterZero = 0;
        int counterOne = 0;

        for (int i = 0; i < s.length; i++) {

            if (s[i] == '0' && (i + 1 == s.length || s[i + 1] != s[i])) {
                counterZero++;
            } else if (s[i] == '1' && (i + 1 == s.length || s[i + 1] != s[i])) {
                counterOne++;
            }

        }

        System.out.println(Math.min(counterZero, counterOne));

    }

}
