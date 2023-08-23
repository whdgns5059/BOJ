package com.my.backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        Queue<Consult> pq = new PriorityQueue<>();
        for(int i = 1 ; i < n+1 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            pq.offer(new Consult(i, t, p));
        }

        int maxP = 0;
        boolean[] visited = new boolean[n+1];
        while(!pq.isEmpty()){
            Consult c = pq.poll();
            if(c.day + c.t - 1 > n ){
                continue;
            }

            if(hasTrue(c, visited)){
                continue;
            }

            for(int i = c.day ; i <= c.day + c.t - 1 ; i++){
                visited[i] = true;
            }
            maxP += c.p;


        }

        System.out.println(maxP);

    }

    private static boolean hasTrue(Consult c, boolean[] visited) {
        for(int i = c.day ; i <= c.day + c.t - 1 ; i++){
            if(visited[i]){
                return true;
            }
        }
        return false;
    }

    private static class Consult implements Comparable<Consult>{
        int day;
        int t;
        int p;
        Double profit;

        public Consult(int day, int t, int p) {
            this.day = day;
            this.t = t;
            this.p = p;
            this.profit = (double)p/t;
        }


        @Override
        public int compareTo(Consult c) {
            return this.profit.compareTo(c.profit) * -1;
        }
    }
}
