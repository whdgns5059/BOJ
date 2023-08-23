package com.my.backjoon.newbie.repeat;

import java.util.Scanner;

public class P10952 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A, B;

        do{

            A = sc.nextInt();
            B = sc.nextInt();

            if(A == 0 && B == 0){
                break;
            }

            System.out.println(A+B);

        }while (A != 0 && B != 0);

    }
}
