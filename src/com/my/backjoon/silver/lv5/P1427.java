package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class P1427 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = br.readLine().toCharArray();
        Character[] characters = new Character[s.length];
        for(int i = 0 ; i < s.length ; i++){
            characters[i] = s[i];
        }

        Arrays.sort(characters, Collections.reverseOrder());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(Character c : characters){
            bw.write(c);
        }

        bw.flush();



    }

}
