package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P1316 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        boolean result = true;
        for(int i = 0 ; i < n ; i++){

            String word = br.readLine();
            Map<Character, Integer> map = new HashMap<>();

            for(int j = 0 ; j < word.length() ; j++){

                Character c = word.charAt(j);

                if(!map.containsKey(c)){
                    map.put(c, 1);
                }else if(word.charAt(j - 1) != c) {
                    result = false;
                    break;
                }


            }

            if(result){
                count++;
            }
            result = true;

        }

        System.out.println(count);


    }
}
