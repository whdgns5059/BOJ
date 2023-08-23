package com.my.backjoon.bronze.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0){
                return;
            }

            int powA = (int) Math.pow(a, 2);
            int powB = (int) Math.pow(b, 2);
            int powC = (int) Math.pow(c, 2);

            if(powA + powB == powC){
                System.out.println("right");
            }else if(powB + powC == powA){
                System.out.println("right");
            } else if (powC + powA == powB) {
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }


    }
}
