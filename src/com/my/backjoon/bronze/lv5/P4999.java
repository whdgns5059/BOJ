package com.my.backjoon.bronze.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4999 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String jaehwan = br.readLine();
        String doctor = br.readLine();

        System.out.println(jaehwan.length() >= doctor.length() ? "go" : "no");


    }

}
