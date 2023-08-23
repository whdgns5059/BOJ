package com.my.backjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P8958 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int counter = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < counter ; i++){

            String answer = br.readLine();

            int sum = 0;
            int point = 1;
            for(int j = 0 ; j < answer.length() ; j++){

                char c = answer.charAt(j);

                if(c == 'O'){
                    sum += point++;
                }else{
                    point = 1;
                }

            }

            System.out.println(sum);

        }

        br.close();

    }
}
