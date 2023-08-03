package com.my.bronze;

import java.util.Scanner;

public class P2577 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int mult = a * b * c;

        int[] cnt = new int[10];

        while(mult > 0){

            int idx = mult % 10;
            cnt[idx]++;

            mult /= 10;

        }

        for(int i : cnt){
            System.out.println(i);
        }
    }
}
