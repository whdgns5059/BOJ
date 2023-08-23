package com.my.backjoon.newbie.function;

import java.util.Scanner;

public class P2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[5];

        int result = 0;
        for(int i = 0 ; i < num.length ; i++){
            num[i] = sc.nextInt();
            result += num[i] * num[i];
        }

        System.out.println(result % 10);

    }
}
