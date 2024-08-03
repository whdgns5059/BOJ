package com.my.backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2941 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String words = br.readLine();

        String[] cro = new String[8];
        cro[0] = "c=";
        cro[1] = "c-";
        cro[2] = "dz=";
        cro[3] = "d-";
        cro[4] = "lj";
        cro[5] = "nj";
        cro[6] = "s=";
        cro[7] = "z=";

        int count = 0;

        for(int i = 0 ; i < cro.length ; i++){

            while(words.contains(cro[i])){
                count++;
                words = words.replaceFirst(cro[i], " ");
            }

        }

        System.out.println(count + words.replaceAll(" ", "").length());





    }

}
