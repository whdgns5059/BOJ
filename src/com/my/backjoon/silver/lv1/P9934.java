package com.my.backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P9934 {

    static List<List<Integer>> tree;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        int[] visited = new int[(int) (Math.pow(2, k)-1)];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < visited.length ; i++){
            visited[i] = Integer.parseInt(st.nextToken());
        }

        tree = new ArrayList<>();
        for(int i = 0 ; i < k ; i++){
            tree.add(new ArrayList<>());
        }

        sortTree(visited, (int) ((Math.pow(2,k) -1) / 2), 0);

        for(List<Integer> l : tree){
            StringBuilder sb = new StringBuilder();
            for(Integer i : l){
                sb.append(i).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }

    }

    private static void sortTree(int[] arr, int index, int level) {

        if(level == k){
            return;
        }

        tree.get(level).add(arr[index]);

        int[] lefthalf = new int[index];
        for(int i = 0 ; i < index ; i++){
            lefthalf[i] = arr[i];
        }
        int[] righthalf = new int[index];
        for(int i = 0 ; i < index ; i++){
            righthalf[i] = arr[i + index+1];
        }

        sortTree(lefthalf, lefthalf.length/2, level+1);
        sortTree(righthalf, righthalf.length/2, level+1);
    }
}
