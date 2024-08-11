package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1251 {

    static char[] str;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toCharArray();

        List<String> list = new ArrayList<>();

        for (int i = 1; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {

                StringBuilder sb = new StringBuilder();
                sb.append(subAndReverse(0, i));
                sb.append(subAndReverse(i, j));
                sb.append(subAndReverse(j, str.length));

                list.add(sb.toString());
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));

    }

    private static String subAndReverse(int i, int j) {

        StringBuilder s = new StringBuilder();

        for (int a = j - 1; a >= i; a--) {
            s.append(str[a]);
        }

        return s.toString();
    }

}
