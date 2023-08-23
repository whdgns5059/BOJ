package com.my.backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P2224 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //인접행렬로 구현, A->0, a->26,
        int length = 26*2; //알파벳개수
        long[][] ajd = new long[length][length];

        for(int i = 0 ; i < length ; i++){
            for(int j =0 ; j < ajd[0].length ; j++){
                ajd[i][j] = Integer.MAX_VALUE;
            }
        }


        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = toIndex(st.nextToken());
            st.nextToken(); //화살표 버리기
            int to = toIndex(st.nextToken());

            ajd[from][to] = 1;
        }

        //플로이드 워셜
        for(int k = 0 ; k < length ; k++){
            for(int i = 0; i < length ; i++ ){
                for(int j = 0 ; j < length ; j++){
                    ajd[i][j] = Math.min(ajd[i][j], ajd[i][k] + ajd[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0 ; i < ajd.length ; i++){
            for(int j = 0 ; j < ajd[i].length ; j++){
                if(ajd[i][j] != Integer.MAX_VALUE && i != j){
                    count++;
                    sb.append(toChar(i)).append(" => ").append(toChar(j)).append("\n");
               }
           }
        }

        System.out.println(count);
        System.out.println(sb.toString());


    }

    private static char toChar(int i) {

        if(0 <= i && i < 26){
            return (char) (i + 'A');
        }else{
            return (char) (i + 'a' - 26);
        }
    }

    private static int toIndex(String s) {

        char c = s.charAt(0);

        if('A' <= c && c <= 'Z'){
            return c - 'A';
        }else{
            return c - 'a' + 26;
        }
    }
}
