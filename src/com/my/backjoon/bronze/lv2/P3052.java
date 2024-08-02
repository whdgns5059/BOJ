package com.my.backjoon.bronze.lv2;

import java.util.Scanner;

public class P3052 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] results = new int[42];

        for(int i = 0; i < 10 ; i++){
            int n = sc.nextInt();
            results[n % 42]++;
        }

        int count = 0;
        for(int i : results){
            if(i != 0){
                count++;
            }
        }

        System.out.println(count);

    }
}
