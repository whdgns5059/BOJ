package com.my.backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1197 {

    static int v;
    static int e;
    static List<List<Edge>> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();
        for(int i = 0 ; i < v + 1 ; i++){
            edgeList.add(new ArrayList<>());
        }
        for(int i = 0 ; i < e ; i ++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.get(from).add(new Edge(from, to, weight));
            edgeList.get(to).add(new Edge(to, from, weight));
        }

        //프림알고리즘.
        int totalWeight = prim(1);
        System.out.println(totalWeight);
    }

    private static int prim(int start) {
        int totalWeight = 0;
        Queue<Edge> pq = new PriorityQueue<>();
        Queue<Integer> q = new LinkedList<>();
        //선택된 정점
        boolean[] visited = new boolean[v+1];
        q.add(start);
        while(!q.isEmpty()){

            int node = q.poll();
            visited[node] = true;

            for(Edge e : edgeList.get(node)){
                if(!visited[e.to]){
                    pq.add(e);
                }
            }

            while(!pq.isEmpty()){
                Edge e = pq.poll();
                if(!visited[e.to]){
                    q.add(e.to);
                    visited[e.to] = true;
                    totalWeight += e.weight;
                    break;
                }
            }

        }

        return totalWeight;
    }



    private static class Edge implements Comparable<Edge>{
        Integer from;
        Integer to;
        Integer weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge e) {
            return this.weight.compareTo(e.weight);
        }

    }
}
