package com.my.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();



        long hash = 0L;
        for(int i = 0 ; i < n ; i++){
            int c = s.charAt(i) - 'a' + 1;
            hash += c * power(i);
        }

        System.out.println(hash % 1234567891);

    }

    private static long power(int i) {
        long prime = 31L;
        long moduler = 1234567891L;
        long result = 1L;
        for(int n = 1 ; n <= i ; n++){
            result *= prime;
            result %= moduler;
        }

        return result;
    }
}
