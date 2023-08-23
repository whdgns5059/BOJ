package com.my.backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(n);

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.add(from, to);
        }


        int[] result = new int[n+1];
        Arrays.fill(result, 1);

        //위상정렬을 이용해 과목의 수강 순서를 정한다.
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i < n + 1 ; i++){
            int count = graph.indegrees.get(i);
            if(count == 0){
                queue.offer(i);
            }
        }

        Map<Integer, Integer> indegreCounter = graph.indegrees;
        while(!queue.isEmpty()){
            int node = queue.poll();

            //다음 노드 찾아 넣기
            for(Node nn : graph.getNodes(node)){
                int to = nn.to;
                int from = nn.from;
                int count = indegreCounter.get(to);
                result[to] = result[from] + 1; //노드를 호출 할때마다 이전 노드값+1 한다
                if(count - 1 == 0){
                    queue.offer(to);
                }
                indegreCounter.put(to, count - 1);
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < result.length ; i++){
            sb.append(result[i]).append(" ");
        }
        System.out.print(sb.toString());


    }
    private static class Graph{
        List<List<Node>> graph;
        //그래프를 구현하면서 진입차수의 개수를 카운트한다
        Map<Integer, Integer> indegrees;



        public Graph(int n) {

            graph = new ArrayList<>();
            indegrees = new HashMap<>();

            for(int i = 0 ; i < n + 1 ; i++){
                graph.add(new ArrayList<>());
                indegrees.put(i, 0);
            }
        }

        public void add(int from, int to){
            graph.get(from).add(new Node(from, to));
            indegrees.put(to, indegrees.get(to) + 1);
        }

        public List<Node> getNodes(int n){
            return this.graph.get(n);
        }

    }

    private static class Node {
        int from;
        int to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
