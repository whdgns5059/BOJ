package com.my.backjoon.silver.lv2;

import java.io.IOException;
import java.util.*;

public class P1260 {

    static int[][] matrix;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        matrix = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            matrix[n1][n2] = 1;
            matrix[n2][n1] = 1;
        }

        List<Integer> dfsSearch = dfs(v);
        List<Integer> bfsSearch = bfs(v);

        for(Integer i : dfsSearch){
            System.out.print(i + " ");
        }
        System.out.println();
        for(Integer i : bfsSearch){
            System.out.print(i + " ");
        }

    }

    private static List<Integer> dfs(int v){

        List<Integer> result = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.add(v);
        while(!stack.isEmpty()){
            int n = stack.pop();
            if(visited.contains(n)){
                continue;
            }else{
                visited.add(n);
            }

            result.add(n);

            for(int i = matrix.length-1 ; i > 0 ; i--){
                if(matrix[n][i] == 1 && !visited.contains(i)){
                    stack.add(i);
                }
            }
        }
        return result;
    }

    private static List<Integer> bfs(int v){

        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited.add(v);

        while(!queue.isEmpty()){

            int next = queue.poll();
            result.add(next);

            for(int i = 0 ; i < matrix.length; i++){
                if(matrix[next][i] == 1 && !visited.contains(i)){
                    queue.add(i);
                    visited.add(i);
                }
            }



        }

        return result;
    }

}
