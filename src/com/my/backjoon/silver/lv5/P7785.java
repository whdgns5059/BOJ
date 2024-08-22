package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P7785 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String commute = st.nextToken();

            if ("enter".equals(commute)) {
                map.put(name, 1);
            } else {
                map.put(name, 0);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                bw.append(entry.getKey() + "\n");
            }
        }

        bw.flush();
        bw.close();


    }

}
