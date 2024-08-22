package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P25757 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int count = 0;
        String game = st.nextToken();
        if ("Y".equals(game)) {
            count = 1;
        } else if ("F".equals(game)) {
            count = 2;
        } else {
            count = 3;
        }

        Set<String> player = new HashSet<>();

        for (int i = 0; i < n; i++) {
            player.add(br.readLine());
        }

        System.out.println(player.size() / count);


    }

}
