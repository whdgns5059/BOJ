package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P1543 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(br.readLine());
        String word = br.readLine();
        String trashWord = IntStream.range(0, word.length())
            .mapToObj(i -> "-")
            .collect(Collectors.joining());

        int count = 0;
        while (true) {

            int index = str.indexOf(word);
            if (index == -1) {
                break;
            }
            count++;
            str.replace(index, index + word.length(), trashWord);
        }

        System.out.println(count);


    }

}
