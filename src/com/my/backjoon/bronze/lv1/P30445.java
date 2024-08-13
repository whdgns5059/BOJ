package com.my.backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class P30445 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        int h = 0;
        int g = 0;

        for (char c : str) {
            if ('H' == c || 'A' == c || 'P' == c || 'Y' == c) {
                h++;
            }
            if ('S' == c || 'A' == c || 'D' == c) {
                g++;
            }
        }

        if (h + g == 0) {
            System.out.println("50.00");
        } else {

            BigDecimal bh = new BigDecimal(String.valueOf(h));
            bh = bh.multiply(new BigDecimal("100"));
            BigDecimal bg = new BigDecimal(String.valueOf(h + g));

            BigDecimal result = bh.divide(bg, 2, RoundingMode.HALF_UP);

            System.out.println(result);
        }

    }

}
