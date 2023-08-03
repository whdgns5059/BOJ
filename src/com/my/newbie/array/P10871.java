package com.my.newbie.array;

import java.util.Scanner;

public class P10871 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < N; i++){
            if(A[i] < X){
                sb.append(A[i] + " ");
            }
        }

        if(sb.length() > 0){
            sb.deleteCharAt(sb.length()-1);
        }

        System.out.println(sb.toString());

    }
}
