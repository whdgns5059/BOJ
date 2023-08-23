package com.my.backjoon.bronze.lv1;

import java.util.Scanner;

public class P11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long result = solution(n, k);

        System.out.println(result);

    }

    private static long solution(int n, int k) {
        if(n < k){
            return 0;
        }
        if(k == 0 || k == n){
            return 1;
        }

        return solution(n-1, k) + solution(n-1, k-1);
    }
}
