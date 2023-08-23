package com.my.backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1003 {

    static long[] zeroCnt;
    static long[] oneCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        zeroCnt = new long[41];
        oneCnt = new long[41];

        zeroCnt[0] = 1;
        zeroCnt[1] = 0;
        oneCnt[0] = 0;
        oneCnt[1] = 1;

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            int m = Integer.parseInt(br.readLine());
            fibonacci(m);
            sb.append(zeroCnt[m]).append(" ")
                .append(oneCnt[m]).append("\n");
        }
        System.out.print(sb.toString());

    }

    static void fibonacci(int n){

        if(n > 2 && zeroCnt[n] != 0 && oneCnt[n] != 0){
            return;
        }

        if(n == 0){
            return;
        }else if(n == 1){
            return;
        }


        fibonacci(n-1);
        fibonacci(n-2);

        if(n > 1){
            zeroCnt[n] = zeroCnt[n-1] + zeroCnt[n - 2];
            oneCnt[n] = oneCnt[n-1] + oneCnt[n - 2];
        }

    }
}
