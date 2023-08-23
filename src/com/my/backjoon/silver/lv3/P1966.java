package com.my.backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1966 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0 ; i < testcase ; i++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Printer> queue = new LinkedList<>();
            for(int j = 0 ; j < n ; j++){
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Printer(j, priority));
            }




            int counter = 0;

            while(!queue.isEmpty()){

                Printer p = queue.poll();

                if(hasGreaterPriority(p, queue)){
                    queue.add(p);
                    continue;
                }else {
                    counter++;
                }
                if(p.index == m){
                    System.out.println(counter);
                    break;
                }

            }


        }

    }

    private static boolean hasGreaterPriority(Printer p, Queue<Printer> queue) {
        return queue.stream().anyMatch(printer -> printer.priority > p.priority);
    }

    private static class Printer{
        int index;
        int priority;

        public Printer(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

    }

}
