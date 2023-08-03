package com.my.silver.lv4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920 {

    static int n;
    static int[] nArr;
    static int m;
    static int[] mArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);

        m = Integer.parseInt(br.readLine());
        mArr = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++){
            mArr[i] = Integer.parseInt(st2.nextToken());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i : mArr){

            int left = 0;
            int right = n;
            while(left +1 < right){

                if(left + 1 == right){
                    break;
                }

                int mid = (left + right) /2;
                if(nArr[mid] == i){
                    left = mid;
                    break;
                }else if(nArr[mid] < i){
                    left = mid;
                }else{
                    right = mid;
                }
            }

            if(nArr[left] == i){
                bw.write("1\n");
            }else{
                bw.write("0\n");
            }

        }


        br.close();
        bw.flush();
        bw.close();


    }

}
