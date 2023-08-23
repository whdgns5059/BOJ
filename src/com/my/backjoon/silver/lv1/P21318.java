package com.my.backjoon.silver.lv1;

import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/21318
public class P21318 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] difficulties = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            difficulties[i] = Integer.parseInt(st.nextToken());
        }

        //악보의 실수 갯수 누적합.
        int[] mistakes = new int[n];
        int sum = 0;
        for(int i = 0; i < n-1; i++ ){
            if(difficulties[i] > difficulties[i+1]) {
                sum += 1;
            }
            mistakes[i+1] = sum; //결과 index를 편하게 관리하기 위해 i+1
        }


        int q = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //누적합에서 x부터 y까지의 값을 구한다
            int result = mistakes[y-1] - mistakes[x-1];
            bw.write(result+"\n");
        }

        br.close();
        bw.close();

    }

}
