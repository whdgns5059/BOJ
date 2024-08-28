package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P25497 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] skills = br.readLine().toCharArray();

        int count = 0;
        Stack<Character> l = new Stack<>();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            char skill = skills[i];
            if ('1' <= skill && skill <= '9') {
                count++;
            } else if (skill == 'L') {
                l.push(skill);
            } else if (skill == 'S') {
                s.push(skill);
            } else if (skill == 'R') {
                if (l.isEmpty()) {
                    break;
                } else {
                    l.pop();
                    count++;
                }
            } else if (skill == 'K') {
                if (s.isEmpty()) {
                    break;
                } else {
                    s.pop();
                    count++;
                }
            }
        }

        System.out.println(count);


    }

}
