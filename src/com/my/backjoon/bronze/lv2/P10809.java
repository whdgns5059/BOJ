package com.my.backjoon.bronze.lv2;

import java.util.Scanner;

public class P10809 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int[] results = new int[26];

        for (int i = 0; i < results.length; i++) {
            results[i] = -1;
        }

        for(int i = 0 ; i < str.length() ; i++){
            int idx = str.charAt(i) - 'a';

            if(results[idx] == -1){
                results[idx] = i;
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int c : results){
            sb.append(c + " ");
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb.toString());

    }
}
