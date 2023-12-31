package com.my.backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int GCD = getGCD(n,m);
        int LCM = getLCM(n,m);

        System.out.println(GCD);
        System.out.println(LCM);

    }

    private static int getLCM(int n, int m) {
        return n * m / getGCD(n,m);
    }

    private static int getGCD(int n, int m) {

        if(m == 0){
            return n;
        }
        return getGCD(m , n % m);
    }
}
