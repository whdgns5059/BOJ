package com.my.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] prices = new int[n];

        for(int i = 0 ; i < n ; i++){
            prices[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int price = 0;
        for(int i = n -1 ; i >= 0 ; i--){
            if(k - price >= prices[i]){
                while(price + prices[i] <= k){
                    price += prices[i];
                    count++;
                }
            }
        }

        System.out.println(count);

    }

}
