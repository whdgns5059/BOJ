package com.my.backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15651 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
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
        permutation(m, 0, result);

        System.out.println(sb.toString());

    }

    private static void permutation(int target, int index, int[] result) {

        if(index == target){
            for(int i : result){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0 ; i < arr.length; i++){
            result[index] = arr[i];
            permutation(target, index + 1, result);
        }

    }
}
