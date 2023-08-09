package com.my.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2231 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 1 ; i  < n ; i++){

            int m = i;
            int sum = 0;
            while(m > 0){
                sum += m % 10;
                m /= 10;
            }
            sum += i;
            if(sum == n){
                System.out.println(i);
                return;
            }

        }

        System.out.println(0);

    }
}
