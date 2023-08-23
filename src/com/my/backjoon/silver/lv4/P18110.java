package com.my.backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P18110 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int exclude = (int) Math.round((n * ((double)3/20)));

        int[] levels = new int[n];
        for(int i = 0 ; i < n ; i++){
            int level = Integer.parseInt(br.readLine());
            levels[i] = level;
        }

        Arrays.sort(levels);
        int[] results = Arrays.copyOfRange(levels, exclude, n-exclude);

        double sum = 0;
        for(int i : results){
            sum += i;
        }

        System.out.println(Math.round(sum / (n - (exclude * 2))));

    }

}
