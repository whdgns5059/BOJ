package com.my.backjoon.bronze.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P30802 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tshirts = new int[6];

        for(int i = 0 ; i < 6 ; i++){
            tshirts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());


        int totalT = 0;
        for(int i = 0 ; i < 6 ; i ++){
            if(tshirts[i] % T == 0){
                totalT += tshirts[i] / T;
            }else{
                totalT += tshirts[i] / T + 1;
            }
        }

        int totalP = N / P;
        int lessP = N % P;

        System.out.println(totalT);
        System.out.println(totalP + " " + lessP);



    }

}
