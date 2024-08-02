package com.my.backjoon.bronze.lv3;

import java.util.Scanner;

public class p1085 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        //w-x 가 x보다 크면 x아니면 w-x
        //h-y 가 y보다 크면 y 아니면 h-y
        //두값중 더 작은게 출력
        int xLength = w-x > x ? x : w-x;
        int yLength = h-y > y ? y : h-y;

        int result = xLength > yLength ? yLength : xLength;

        System.out.println(result);
    }
}
