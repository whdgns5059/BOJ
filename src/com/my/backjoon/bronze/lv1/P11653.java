package com.my.backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P11653 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int divider = 2;

        while(n > 1){

            if(n % divider == 0){
                n /= divider;

                bw.write(String.valueOf(divider));
                bw.append("\n");

                divider = 2;
            }else {
                divider++;
            }

        }


        bw.flush();

    }

}
