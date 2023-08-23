package com.my.backjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1978 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int counter = 0;
        for(int i = 0 ; i < n ; i ++){
            if(isPrime(nums[i])){
                counter++;
            }
        }
        System.out.println(counter);

    }

    private static boolean isPrime(int num) {
        if(num == 1){
            return false;
        }
        for(int i = num -1; i > 1 ; i--){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
