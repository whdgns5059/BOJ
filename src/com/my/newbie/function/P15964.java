package com.my.newbie.function;

import java.util.Scanner;

public class P15964 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        long result = (long)(a + b) * (a - b);

        System.out.println(result);
    }
}
