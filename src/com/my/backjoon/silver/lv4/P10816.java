package com.my.backjoon.silver.lv4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10816 {
    static int n;
    static long[] nArr;
    static int m;
    static long[] mArr;
    static int[] counter;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nArr = new long[n];
        for(int i = 0 ; i < n ; i++){
            nArr[i] = Long.parseLong(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        mArr = new long[m];
        counter = new int[m];
        for(int i = 0 ; i < m ; i++){
            mArr[i] = Long.parseLong(st2.nextToken());
        }

        Arrays.sort(nArr);

        for(int i = 0 ; i < mArr.length ; i++){

            int hi = lowerbound(nArr, mArr[i]);
            int low = upperbound(nArr, mArr[i]);

            counter[i] = low - hi;

        }


        StringBuilder sb = new StringBuilder();
        for(int i : counter){
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb.toString());

    }

    private static int lowerbound(long[] nArr, long l) {
        int lo = -1, hi = n;
        while(lo + 1 < hi){
            int mid = (lo+hi)/2;
            if(!(nArr[mid] >= l)){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        return hi;
    }
    private static int upperbound(long[] nArr, long l) {
        int lo = -1, hi = n;
        while(lo + 1 < hi){
            int mid = (lo+hi)/2;
            if(!(nArr[mid] > l)){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        return hi;
    }

}
