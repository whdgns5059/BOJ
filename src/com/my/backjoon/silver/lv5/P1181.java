package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1181 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> wordList = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            if(!wordList.contains(str)){
                wordList.add(str);
            }
        }

        Collections.sort(wordList, (s, t1) -> {
           int result = 0;

           if(s.length() - t1.length() == 0){
               return s.compareTo(t1);
           }
           return s.length() - t1.length();
        });

        for(String str : wordList){
            System.out.println(str);
        }
    }
}
