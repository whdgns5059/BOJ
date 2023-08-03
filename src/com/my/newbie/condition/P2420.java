package com.my.newbie.condition;

import java.util.Scanner;

public class P2420 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N, M;

        N = sc.nextInt();
        M = sc.nextInt();

        long result;

        if(N >= M){
            result = (long)N - M;
        }else{
            result = (long)M - N;
        }

        System.out.println(result);


    }
}
