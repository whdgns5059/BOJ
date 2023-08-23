package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1654 {

    static int k, n;
    static long max;
    static long[] lans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] kn = br.readLine().split(" ");
        k = Integer.parseInt(kn[0]);
        n = Integer.parseInt(kn[1]);
        lans = new long[k];
        max = 0;
        for(int i = 0 ; i < k ; i++){
            long lan = Long.parseLong(br.readLine());
            lans[i] = lan;
            max = Math.max(lan, max);
        }

        long low = 0;
        long high = max + 1; //div/0을 방지, UpperBound

        while(low + 1 < high){

            long mid = (low + high) / 2L;

            if(Check(mid)){
                high = mid;
            }else{
                low = mid;
            }
        }

        System.out.println(low);
    }

    private static boolean Check(long mid) {
        long sumOfcut = 0;
        for(int i = 0 ; i < k ; i++){
            sumOfcut += lans[i] / mid;
        }
        return sumOfcut < n;
    }
}
