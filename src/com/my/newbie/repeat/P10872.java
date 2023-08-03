package com.my.newbie.repeat;

import java.util.Scanner;

public class P10872 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int result = 1;

        while(N > 1){
            result *= N;
            N--;
        }

        System.out.println(result);

    }
}
