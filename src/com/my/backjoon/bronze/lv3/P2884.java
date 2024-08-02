package com.my.backjoon.bronze.lv3;

import java.util.Scanner;

public class P2884 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();

        int movedUpMin = 45;

        if(m - movedUpMin < 0){
            h -= 1;
            m += 15;

            if(h < 0){

                h += 24;

            }

        }else{
            m -= movedUpMin;
        }

        System.out.println(h + " " + m);

    }
}
