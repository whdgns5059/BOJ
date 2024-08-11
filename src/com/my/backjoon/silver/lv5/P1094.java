package com.my.backjoon.silver.lv5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1094 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 64;
        int x = Integer.parseInt(br.readLine());
        List<Integer> sticks = new ArrayList<>();
        sticks.add(n);

        while (x < sumOfSticks(sticks)) {

            int shortStick = sticks.get(sticks.size() - 1);
            sticks.remove(sticks.size() - 1);

            int halfStick = shortStick / 2;
            sticks.add(halfStick);

            if (sumOfSticks(sticks) < x) {
                sticks.add(halfStick);
            }

        }

        System.out.println(sticks.size());


    }

    private static int sumOfSticks(List<Integer> sticks) {
        return sticks.stream().reduce(Integer::sum).get();
    }

}
