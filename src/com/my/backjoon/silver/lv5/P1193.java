package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1193 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int i = 1;

        while(n > i){
            n -= i++;
        }

        if(i % 2 == 0){
            System.out.println(n + "/" + (i + 1 - n));
        }else {
            System.out.println((i + 1 - n) + "/" + n);
        }



    }

}
