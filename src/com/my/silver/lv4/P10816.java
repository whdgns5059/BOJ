package com.my.silver.lv4;

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

            int left = 0;
            int right = n;
            while(left +1 < right){

                if(left + 1 == right){
                    break;
                }

                int mid = (left + right) /2;
                if(nArr[mid] == mArr[i]){
                    left = mid;
                    break;
                }else if(nArr[mid] < mArr[i]){
                    left = mid;
                }else{
                    right = mid;
                }
            }


            if(nArr[left] == mArr[i]){
               int count = 0;
               int upper = left;
               while(nArr[upper] == mArr[i]){
                   count++;
                   if(upper++ >= n-1){
                       break;
                   }
               }
               int lower = left > 0 ? left - 1 : left;
                while(nArr[lower] == mArr[i] && left > 0){
                    count++;
                    if(lower-- == 0){
                        break;
                    }
                }
               counter[i] = count;
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int i : counter){
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb.toString());

    }
}
