package com.my.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2435
public class P2435 {

    public int solve(int n, int k, int[] arr) {

        int[] prefixSum = new int[n+1];
        int sum = 0;
        for(int i = 0 ; i <n ; i++){
            sum += arr[i];
            prefixSum[i+1] = sum;

        }

        int max = Integer.MIN_VALUE;
        for(int i = k ; i < n+1 ; i++){
            max = Math.max(prefixSum[i] - prefixSum[i-k], max);
        }

        System.out.println(max);
        return max;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        new P2435().solve(n, k, arr);
    }

}
