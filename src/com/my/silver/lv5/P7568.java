package com.my.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P7568 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] peoples = new int[n][2];

        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            peoples[i][0] = Integer.parseInt(st.nextToken());
            peoples[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] ranks = new int[n];
        Arrays.fill(ranks, n);
        for(int i = 1; i < n ; i++){
            int[] p = peoples[i];
            for(int j = 0 ; j < n ; j++){



            }
        }

        for(int i : ranks){
            System.out.println(i);
        }


    }

}
