package com.my.backjoon.silver.lv3;

import java.io.*;
import java.util.*;

public class P1929 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[1] = false;
        primes[2] = true;

        for(int i = 2; i < n+1 ; i++){

            if(primes[i]){

                for(int j = i * 2 ; j < n+1; j += i){
                    if(j % i == 0){
                        primes[j] = false;
                    }
                }

            }


        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = m ; i <= n ; i++){
            if(primes[i]){
                bw.write(i+"\n");
            }
        }

        br.close();
        bw.close();

    }

}
