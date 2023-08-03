package com.my.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2675 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        String[] results = new String[count];
        for(int i = 0; i < count ; i++){

            String[] texts = br.readLine().split(" ");

            int mulitplier = Integer.parseInt(texts[0]);
            String result = "";

            for(int j = 0; j < texts[1].length() ; j++){

                char c = texts[1].charAt(j);
                String mulitpledChar = "";
                for(int k = 0; k < mulitplier ; k++){
                    mulitpledChar += c;
                }
                result += mulitpledChar;
            }

            results[i] = result;
        }

        for (String result: results) {
            System.out.println(result);
        }

    }
}
