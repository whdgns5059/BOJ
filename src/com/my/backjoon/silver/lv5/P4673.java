package com.my.backjoon.silver.lv5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P4673 {



    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[10001];
        Arrays.fill(arr, 0);

        for(int i = 1 ; i < 10000 ; i++){

            if(arr[i] == 0){
                bw.write(i + "\n");

                addNum(arr, i);

            }

        }

        bw.flush();
    }

    private static void addNum(int[] arr, int i) {

       arr[i] = 1;

       while(i < 10001){

           int num = i;
           while(num > 0){
               i += num % 10;
               num /= 10;
           }

           if(i < 10000){
               arr[i] = 1;
           }


       }

    }


}
