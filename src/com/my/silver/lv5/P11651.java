package com.my.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] plane = new int[n][2];
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            plane[i][0] = Integer.parseInt(st.nextToken());
            plane[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(plane, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {

                if(a1[1] == a2[1]) {
                    if(a1[0] == a2[0]) return 0;
                    else if(a1[0] > a2[0]) return 1;
                    else return -1;
                }else if(a1[1] > a2[1]) return 1;
                else return -1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int[] a : plane){
           sb.append(a[0]).append(" ").append(a[1]).append("\n");
        }
        System.out.println(sb.toString());


    }
}
