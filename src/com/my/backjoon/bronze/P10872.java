package com.my.backjoon.bronze;

import java.util.Scanner;

public class P10872 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = factorial(n);

        System.out.println(result);

    }

    private static int factorial(int n) {
        if(n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }
}
