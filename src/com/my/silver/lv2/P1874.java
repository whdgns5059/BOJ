package com.my.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class P1874 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sequence = new int[n];
        for(int i = 0 ; i < n ; i++){
            sequence[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        int num = 1;
        int[] result = new int[n];
        List<String> resultList = new ArrayList<>();

        for(int i = 1 ; i <= n ; i++ ){



        }

        System.out.println(Arrays.toString(result));




    }
}
