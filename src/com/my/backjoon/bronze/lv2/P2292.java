package com.my.backjoon.bronze.lv2;

import java.util.Scanner;

public class P2292 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        int counter = 1;
        long hex = 1;
        while(hex < n ){
            hex = hex + (counter * 6L);
            counter++;
        }
        System.out.println(counter);
    }
}
