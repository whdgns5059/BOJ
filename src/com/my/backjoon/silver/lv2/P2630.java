package com.my.backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {
    static Papers papers;
    static int whiteCount;
    static int blueCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        whiteCount = 0;
        blueCount = 0;

        papers = new Papers(n);

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                papers.add(st.nextToken(), i, j);
            }
        }

        countWhiteBlue(n, 0, 0);

        System.out.println(whiteCount);
        System.out.println(blueCount);

    }

    private static void countWhiteBlue(int n, int x, int y) {

        int bluePieces = papers.countBluePieces(n, x, y);

        if(bluePieces == n*n){
            blueCount++;
            return;
        }else if(bluePieces == 0){
            whiteCount++;
            return;
        }else{
            countWhiteBlue(n/2, x, y);
            countWhiteBlue(n/2, x, y + n/2);
            countWhiteBlue(n/2, x+n/2, y);
            countWhiteBlue(n/2, x+n/2, y+n/2);
        }
    }


    private static class Papers {
        Paper[][] papers;
        Papers(int n){
            this.papers = new Paper[n][n];
        }
        void add(String s, int i, int j){
            this.papers[i][j] = new Paper(s);
        }

        public int countBluePieces(int n, int x, int y) {
            int count = 0;
            for(int i = x; i < x+n ; i++){
                for(int j = y; j < y+n; j++){
                    if(papers[i][j].isBlue()){
                        count++;
                    }
                }
            }
            return count;
        }
    }

    private static class Paper {
        int color;
        Paper(String color){
            this.color = Integer.parseInt(color);
        }
        boolean isBlue(){
            return color == 1;
        }


    }



}

