package com.my.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P11399 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] waits = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            waits[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(waits);

        int sum = 0;
        int[] results = new int[n];
        for(int i = 0 ; i < n; i++){
            sum = sum + waits[i];
            results[i] = sum;
        }

        int result = 0;
        for(int i : results){
            result += i;
        }

        System.out.println(result);
    }
}
