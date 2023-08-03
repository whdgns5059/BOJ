package com.my.silver.lv5;

import java.util.Scanner;

public class P1676 {

    static int cnt;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        cnt = n / 5 + n / 25 + n / 125;
        System.out.println(cnt);
    }
}
