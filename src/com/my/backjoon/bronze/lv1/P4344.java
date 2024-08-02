package com.my.backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4344 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count ; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());

            int[] points = new int[number];
            int total = 0;

            for(int j = 0 ; j < number ; j++){
                points[j] = Integer.parseInt(st.nextToken());
                total += points[j];
            }

            double avg = (double) total / number;

            int upper = 0;
            for(int j = 0 ; j < number ; j++){
                if(avg < points[j]){
                    upper++;
                }
            }

            System.out.printf("%.3f%%\n", ((double)upper / number )* 100);

        }


    }

}
