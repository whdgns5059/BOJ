package com.my.backjoon.bronze;

import java.util.Scanner;

public class P2562 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];
        int max = 0;
        int counter = 0;
        for(int i = 0 ; i < 9 ; i++){
            arr[i] = sc.nextInt();
            if(max < arr[i]){
                max = arr[i];
                counter = i+1;
            }
        }

        System.out.println(max);
        System.out.println(counter);

    }
}
