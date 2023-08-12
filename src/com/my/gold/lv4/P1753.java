package com.my.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753 {

    static int n;
    static List<List<Node>> graph;
    static int[] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i = 0 ; i < n+1 ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < e ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v,w));
        }

        costs = new int[n+1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        dijkstra(k);


        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n+1 ; i++){
            String cost = costs[i] == Integer.MAX_VALUE ? "INF" : String.valueOf(costs[i]);
            sb.append(cost).append("\n");
        }
        System.out.println(sb.toString());

    }

    private static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1.cost, n2.cost);
        });

        pq.offer(new Node(start, 0));
        costs[start] = 0;

        while(!pq.isEmpty()){

            Node current = pq.poll();

            if(costs[current.index] < current.cost){
                continue;
            }

            for(int i = 0 ; i < graph.get(current.index).size() ; i++){
                Node next = graph.get(current.index).get(i);
                if(costs[next.index] > current.cost + next.cost){
                    costs[next.index] = current.cost + next.cost;
                    pq.offer(new Node(next.index, costs[next.index]));
                }
            }

        }

    }

    private static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
