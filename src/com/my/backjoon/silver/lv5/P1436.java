package com.my.backjoon.silver.lv5;

import java.util.Scanner;

public class P1436 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int i = 0;
        int num = 665;
        while(i < n){
            if(has666(num++)){
                i++;
            }
        }

        System.out.println(num-1);


    }


    private static boolean has666(int num) {

        int sixCounter = 0;

        while(num > 0){
            if(num % 10 == 6){
                sixCounter++;
            }else{
                sixCounter = 0;
            }

            num /= 10;

            if(sixCounter == 3){
                return true;
            }
        }
        return false;
    }
}

