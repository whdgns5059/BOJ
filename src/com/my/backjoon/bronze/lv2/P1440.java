package com.my.backjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1440 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");

        int count = 0;
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());

        if (isHour(first) && isMinute(second) && isSecond(third)) {
            count++;
        }

        if (isHour(first) && isSecond(second) && isMinute(third)) {
            count++;
        }

        if (isMinute(first) && isHour(second) && isSecond(third)) {
            count++;
        }

        if (isMinute(first) && isSecond(second) && isHour(third)) {
            count++;
        }

        if (isSecond(first) && isMinute(second) && isHour(third)) {
            count++;
        }

        if (isSecond(first) && isHour(second) && isMinute(third)) {
            count++;
        }

        System.out.println(count);

    }

    private static boolean isSecond(int i) {
        return 0 <= i && i <= 59;
    }

    private static boolean isMinute(int i) {
        return 0 <= i && i <= 59;
    }

    private static boolean isHour(int i) {
        return 0 < i && i <= 12;
    }

}
