package com.my.backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15650 {
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = i+1;
        }

        //순열 통해서 결과 뽑기..
        int[] result = new int[m];
        sb = new StringBuilder();
        permutation(result, m, 0, 0);

        System.out.println(sb.toString());
    }

    private static void permutation(int[] result, int target, int index, int depth) {

        if(target == 0){
            for(int i : result){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        if(depth == arr.length) {
            return;
        }

        result[index] = arr[depth];
        permutation(result, target-1, index + 1, depth+1);
        permutation(result, target, index, depth + 1);

    }
}
