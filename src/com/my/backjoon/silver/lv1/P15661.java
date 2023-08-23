package com.my.backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P15661 {

    static int[][] matrix;
    static List<Integer> min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];
        min = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            String[] strs = br.readLine().split(" ");
            for(int j = 0; j < strs.length; j++){
                matrix[i][j] = Integer.parseInt(strs[j]);
            }
        }

        for(int i = 1; i < n ; i ++){
            int[] team = new int[i];
            combination(team, n, i, 0, 1);
        }

        System.out.println(min.stream().min(Comparator.naturalOrder()).orElse(0));

    }

    private static void combination(int[] team, int n, int r, int index, int depth) {
        if(r == 0){
            minTeamPower(team);
            return;
        }

        if(depth == n){
            return;
        }

        team[index] = depth;

        combination(team, n, r-1, index + 1, depth+1);
        combination(team, n, r, index, depth + 1);

    }

    private static void minTeamPower(int[] team1) {

        int team1Power = 0;
        int team2Power = 0;
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0 ; j < matrix[i].length; j++){
                if(contains(team1, i) && contains(team1, j)){
                    team1Power += matrix[i][j];
                }else if(!contains(team1, i) && !contains(team1, j)){
                    team2Power += matrix[i][j];
                }
            }
        }

        min.add(Math.abs(team1Power - team2Power));

    }


    static boolean contains(int[] arr, int n){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]-1 == n){
                return true;
            }
        }
        return false;
    }



}
