package com.my.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2606 {
    static int[][] adj;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int v = Integer.parseInt(br.readLine());

        adj = new int[n+1][n+1];
        for(int i = 0 ; i < v ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from][to] = 1;
            adj[to][from] = 1;
        }
        count = 0;
        boolean[] visited = new boolean[n+1];
        dfs(1, visited);

        System.out.println(count);
    }

    private static void dfs(int start, boolean[] visited) {


        visited[start] = true;
        int[] nodes = adj[start];

        for(int i = 1 ; i < nodes.length ; i++){

            if(nodes[i] != 0 && !visited[i]){
                count += 1;
                dfs(i, visited);
            }
        }

    }
}
