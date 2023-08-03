package com.my.silver.lv4;

import java.util.Scanner;

public class P2839 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;

        while(n >= 0){

            if(n % 5 == 0){
                count += n / 5;
                break;
            }

            n -= 3;
            count++;
            if(0 < n && n < 3){
                System.out.println(-1);
                return;
            }

        }

        System.out.println(count);
    }
}
