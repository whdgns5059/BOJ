package com.my.backjoon.bronze;

import java.util.Scanner;

public class P10870 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = fiboncci(n);

        System.out.println(result);
    }

    private static int fiboncci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return fiboncci(n-1) + fiboncci(n - 2);
    }
}
