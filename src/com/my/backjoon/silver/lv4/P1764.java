package com.my.backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1764 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int listen = Integer.parseInt(st.nextToken());
        int see = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(int i = 0 ; i < listen ; i++){
            String name = br.readLine();
            map.put(name, 1);
        }

        for(int  i = 0 ; i < see ; i++){
            String name = br.readLine();
            if(map.get(name) != null){
                result.add(name);
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for(String name : result){
            sb.append(name).append("\n");
        }
        System.out.println(sb.toString());

    }
}
