package com.my.backjoon.bronze;

import java.util.Scanner;

public class P2920 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] scales = new int[8];

        for(int i = 0 ; i < 8; i++){
            scales[i] = sc.nextInt();
        }

        int current = scales[0];
        String result = "";

        for(int i = 1 ; i < scales.length ; i++){

            int calc = current - scales[i];
            current = scales[i];

            if(calc == -1){
                result = "ascending";
            }else if(calc == 1){
                result = "descending";
            }else{
                result = "mixed";
                break;
            }

        }

        System.out.println(result);


    }
}
