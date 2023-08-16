package com.my.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1012 {

    static int[][] dxdy = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int a = 0 ; a < t ; a++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] field = new int[n][m];

            for(int i = 0 ; i < k ; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }

            int count = 0;

            boolean[][] visited = new boolean[n][m];

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(field[i][j] == 1 && !visited[i][j]){
                        count++;
                        dfs(field, visited, i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int[][] field, boolean[][] visited, int i, int j) {

        if(visited[i][j] || field[i][j] == 0){
            return;
        }

        visited[i][j] = true;

        for(int k = 0 ; k < 4 ; k++){
            int di = i + dxdy[k][0];
            int dj = j + dxdy[k][1];
            if(!(di < 0 || dj < 0 || di >= n || dj >= m)){
                dfs(field, visited, di, dj);
            }

        }

    }
}
