package com.my.backjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2798 {

    static int n;
    static int k;
    static int[] arr;
    static int reuslt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0 ; i < n ; i++){
             arr[i] = Integer.parseInt(st2.nextToken());
        }

        int result = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                for(int m = j + 1 ; m < n ; m++){
                    int sum = arr[i] + arr[j] + arr[m];
                    if(sum <= k)
                        result = Math.max(sum, result);
                }
            }
        }



        System.out.println(result);
    }


}
