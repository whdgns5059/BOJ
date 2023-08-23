package com.my.backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13023 {

    static int[][] adjacency;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacency = new int[n][n];
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacency[a][b] = 1;
            adjacency[b][a] = 1;
        }

        for(int i = 0 ; i < n ; i++){
            dfs(i, 1, new boolean[n]);
        }

        System.out.println(result);

    }

    private static void dfs(int n, int depth, boolean[] visited) {
        if(depth >= 5){
            result = 1;
            return;
        }


        int[] arr = adjacency[n];
        visited[n] = true;


        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] ==  1 && !visited[i]){
                dfs(i, depth + 1, visited);
            }
        }
        //만약 dfs를 돌았는데 결과가 안나왔으면 방문노드 반환
        visited[n] = false;
    }
}
