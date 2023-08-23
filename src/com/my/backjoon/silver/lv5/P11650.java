package com.my.backjoon.silver.lv5;

import java.io.*;
import java.util.StringTokenizer;

public class P11650 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] dot = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            arr[i] = dot;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int[] a : arr){
            StringBuilder sb = new StringBuilder();
            sb.append(a[0]).append(" ").append(a[1]).append("\n");
            bw.write(sb.toString());;
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
