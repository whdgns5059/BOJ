package com.my.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<String> pokemon = new ArrayList<>();
        Map<String, Integer> pokemonMap = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            String s = br.readLine();
            pokemon.add(s);
            pokemonMap.put(s, i+1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i++){
            String s = br.readLine();

            if(isNumber(s)){
                sb.append(pokemon.get(Integer.parseInt(s) - 1)).append("\n");
            }else{
                sb.append(pokemonMap.get(s)).append("\n");
            }

        }
        System.out.println(sb.toString());

    }

    private static boolean isNumber(String s) {

        try {
            int i = Integer.parseInt(s);
        } catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }
}
