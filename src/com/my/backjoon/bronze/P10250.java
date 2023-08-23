package com.my.backjoon.bronze;

import java.util.Scanner;

public class P10250 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        for(int i = 0 ; i < count ; i++){

            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            int floor = (n % h) == 0 ? h : n % h;

            int num = (int)Math.ceil(n / (double) h);
            String numStr = num < 10 ? "0" + num : "" + num;

            System.out.println(floor+numStr);
        }

    }
}

