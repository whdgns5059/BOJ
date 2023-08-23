package com.my.backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1018 {
    public static void main(String[] args) throws IOException {

        final int BOARD_SIZE = 8;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);

        String[][] board = new String[m][n];

        for(int i = 0 ; i < m; i++){
            String[] line = br.readLine().split("");
            for(int j = 0 ; j < n; j++){
                board[i][j] = line[j];
            }
        }

        List<Integer[]> startIndexes = new ArrayList<>();

        for(int i = 0 ; i <= m - BOARD_SIZE; i++){
            for(int j = 0 ; j <= n - BOARD_SIZE; j++){
                startIndexes.add(new Integer[]{i,j});
            }
        }

        int minResult = Integer.MAX_VALUE;

        for(Integer[] startIndex : startIndexes){
            String startColor = board[startIndex[0]][startIndex[1]];
            int result1 = 0;
            int result2 = 0;
            boolean colorFlag = true;
            for(int i = startIndex[0] ; i < startIndex[0] + BOARD_SIZE ; i++){
                for(int j = startIndex[1] ; j < startIndex[1] + BOARD_SIZE ; j++ ){
                    String color = board[i][j];

                    if(colorFlag){
                        if(!color.equals(startColor)){
                            result1++;
                        }
                        if(color.equals(startColor)){
                            result2++;
                        }
                    }else{
                        if(color.equals(startColor)){
                            result1++;
                        }
                        if(!color.equals(startColor)){
                            result2++;
                        }
                    }
                    colorFlag = !colorFlag;
                }
                colorFlag = !colorFlag;
            }

            int result = Math.min(result1, result2);

            if(minResult > result){
                minResult = result;
            }

        }

        System.out.println(minResult);

    }
}

