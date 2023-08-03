package com.my.newbie.repeat;

import java.util.Scanner;

public class P10950 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        int A, B;

        while(count > 0){

            A = sc.nextInt();
            B = sc.nextInt();

            System.out.println(A+B);

            count--;
        }

    }
}
