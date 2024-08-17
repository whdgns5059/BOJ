package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1417 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> votes = new PriorityQueue<>(
            (o1, o2) -> -o1.compareTo(o2)
        );
        for (int i = 0; i < n - 1; i++) {
            votes.offer(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while (!votes.isEmpty() && votes.peek() >= dasom) {
            votes.offer(votes.poll() - 1);
            dasom++;
            count++;
        }

        System.out.println(count);


    }

}
