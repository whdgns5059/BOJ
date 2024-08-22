package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class P4158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = -1;
        int m = -1;

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            Map<String, Boolean> sanguen = new HashMap<>();
            for (int i = 0; i < n; i++) {
                sanguen.put(br.readLine(), false);
            }

            for (int i = 0; i < m; i++) {
                String sunyoung = br.readLine();

                if (sanguen.containsKey(sunyoung)) {
                    sanguen.put(sunyoung, true);
                }

            }

            int count = 0;
            for (Entry<String, Boolean> entry : sanguen.entrySet()) {
                if (entry.getValue()) {
                    count++;
                }
            }

            System.out.println(count);
        }

    }

}
