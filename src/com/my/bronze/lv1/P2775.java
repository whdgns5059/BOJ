package com.my.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2775 {

    static int t;
    static int[] target;
    static long[][] room;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine()) * 2;
        target = new int[t];
        int maxfloor = 0;
        for(int i = 0 ; i < t ; i++){
            target[i] = Integer.parseInt(br.readLine());
            if(i % 2 == 0){
                maxfloor = Math.max(target[i], maxfloor);
            }
        }

        //방초기화
        room = new long[maxfloor+1][15];
        for(int i = 0 ; i < room[0].length ; i++){
            room[0][i] = i;
        }

        for(int i = 0 ; i < t ; i+=2){
            int k = target[i];
            int n = target[i+1];

            System.out.println(getResult(k, n));


        }


    }

    private static long getResult(int k, int n) {

        if(room[k][n] != 0 || k == 0){
            return room[k][n];
        }

        for(int i = k-1 ; i < k ; i++){
            for(int j = 0 ; j <= n ; j++){
                room[k][n] +=  getResult(i,j);
            }
        }
        return room[k][n];
    }
}
