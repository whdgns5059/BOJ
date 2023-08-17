package com.my.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P11657 {

    static int INF = Integer.MAX_VALUE;
    static int n, m;
    static List<Node> edges ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) -1;
            int to = Integer.parseInt(st.nextToken()) -1;
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Node(from, to, cost));

        }

        long[] dist = belmanFord(0);

        if(dist[0] == -1){
            System.out.println("-1");
            return;
        }

        StringBuilder sb= new StringBuilder();
        for(int i = 1 ; i < n ; i++){
            long result = dist[i] == INF ? -1 : dist[i];
            sb.append(result).append("\n");
        }
        System.out.print(sb);

    }

    private static long[] belmanFord(int start) {
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for(int i = 0 ; i < n -1 ; i++){
           for(int j = 0 ; j < m ; j++){
                Node node = edges.get(j);
                int from = node.from;
                int to = node.to;
                int cost = node.cost;

                if(dist[from] == INF) continue;
                if(dist[to] > dist[from] + cost){
                    dist[to] = dist[from] + cost;
                }
           }
        }

        for(int i = 0 ; i < m ; i++){
            Node node = edges.get(i);
            int from = node.from;
            int to = node.to;
            int cost = node.cost;

            if(dist[from] == INF) continue;
            if(dist[to] > dist[from] + cost){
                return new long[]{-1};
            }
        }
        return dist;

    }


    private static class Node {
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
