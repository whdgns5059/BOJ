package com.my.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1152 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str);

        int counter = 0;

        while(st.hasMoreTokens()){
            st.nextToken();
            counter++;
        }

        System.out.println(counter);

    }
}
