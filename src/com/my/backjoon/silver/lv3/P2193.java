package com.my.backjoon.silver.lv3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //이친수가 아니면 true;
        int[] dp = new int[n+1];
        dp[1] = 1;
        int count = 1;
        for(int i = 1 ; i < n+1 ; i++){

            int num = i;
            int remain = 0;
            while(num > 0){

                if(dp[num] != 0){
                    dp[i] = count + 1;
                    break;
                }
                if(remain == 1 && num % 2 == 1){
                    dp[i] = count + 1;
                    break;
                }

                remain = num % 2;
                num /= 2;

            }
            

        }

        System.out.println(dp[n]);

    }
}
