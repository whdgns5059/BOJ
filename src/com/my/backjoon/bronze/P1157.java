package com.my.backjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1157 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();

        int[] arr = new int[26];

        for(int i = 0; i < str.length() ; i++){

            int index = str.charAt(i) - 'A';
            arr[index]++;

        }

        int max = -1;
        int index = 0;

        for(int i = 0; i < arr.length ; i++){
            if(max < arr[i]){
                max = arr[i];
                index = i;
            }

        }

        int maxCounter = 0;
        for(int a : arr){
            if(max == a && maxCounter++ >= 1){
                System.out.println("?");
                return;
            }
        }

        char resultNum = (char)(index + 'A');

        System.out.println(resultNum);



    }
}
