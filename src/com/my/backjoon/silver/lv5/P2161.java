package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class P2161 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        IntStream.rangeClosed(1, n).forEach(queue::offer);

        int count = 0;
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {

            if (count % 2 == 0) {
                result.add(queue.poll());
            } else {
                queue.offer(queue.poll());
            }
            count++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : result) {
            bw.append(i + " ");
        }
        bw.flush();
        bw.close();


    }

}
