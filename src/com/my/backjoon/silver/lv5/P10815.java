package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P10815 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(st.nextToken(), false);
        }

        int m = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if (map.containsKey(st2.nextToken())) {
                bw.append("1 ");
            } else {
                bw.append("0 ");
            }
        }

        bw.flush();
        bw.close();


    }

}
