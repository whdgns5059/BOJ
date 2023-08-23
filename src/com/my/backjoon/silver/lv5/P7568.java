package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7568 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Person[] peoples = new Person[n];

        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            peoples[i] = new Person(weight, height);
        }

        for(int i = 0; i < n ; i++){
            Person p = peoples[i];

            for(int j = 0 ; j < n ; j++){
                if(i == j){
                    continue;
                }

                Person p2 = peoples[j];
                if(p.isSmall(p2)){
                    p.rank++;
                }

            }
        }

        for(Person p : peoples){
            System.out.println(p.rank);
        }



    }

    private static class Person {
        int weight;
        int height;
        int rank;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
            rank = 1;
        }

        public boolean isSmall(Person p2) {
            return this.weight < p2.weight && this.height < p2.height;
        }
    }
}
