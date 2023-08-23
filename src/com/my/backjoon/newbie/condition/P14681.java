package com.my.backjoon.newbie.condition;

import java.util.Scanner;

public class P14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x, y;

        x = sc.nextInt();
        y = sc.nextInt();

        int quadarant;

        if(x > 0 && y > 0){
            quadarant = 1;
        }else if(x < 0 && y > 0){
            quadarant = 2;
        }else if(x < 0 && y < 0){
            quadarant = 3;
        }else{
            quadarant = 4;
        }

        System.out.println(quadarant);


    }
}
