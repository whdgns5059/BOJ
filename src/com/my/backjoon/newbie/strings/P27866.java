package com.my.backjoon.newbie.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P27866 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());

        br.close();

        System.out.println(s.charAt(i-1));

    }
}
