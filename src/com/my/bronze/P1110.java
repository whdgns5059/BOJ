package com.my.bronze;

import java.util.Scanner;

public class P1110 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = n;
        int count = 0;

        do{
            int left = result / 10;
            int right = result % 10;

            int sum = (left + right) % 10;

            result = right * 10 + sum;

            count++;
        }while(n != result);


        System.out.println(count);

    }
}
